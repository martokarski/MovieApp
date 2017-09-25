package org.mautokar.movieapp.ui.activity

import android.app.ProgressDialog
import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.coroutines.experimental.CancellationException
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import org.mautokar.movieapp.R
import org.mautokar.movieapp.databinding.ActivityMainBinding
import org.mautokar.movieapp.service.MovieService
import org.mautokar.movieapp.ui.adapter.MovieAdapter
import org.mautokar.movieapp.coroutine.Android
import org.mautokar.movieapp.util.app
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var job: Job
    private lateinit var dialog: ProgressDialog
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var movieService: MovieService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.component.inject(this)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val layoutManager = binding.recycler.layoutManager
        if (layoutManager is GridLayoutManager) {
            layoutManager.spanCount = if (Configuration.ORIENTATION_PORTRAIT == resources.configuration.orientation) 2 else 3
        }

        dialog = ProgressDialog(this).apply {
            setCancelable(false)
            setMessage("Fetching data")
            show()
        }

        job = init()
    }

    override fun onDestroy() {
        job.cancel(CancellationException("MainActivity is destroyed"))
        dialog.dismiss()
        super.onDestroy()
    }

    private fun init() = launch(Android) {
        val list = movieService.movies.await()
        binding.recycler.adapter = MovieAdapter(list)

        dialog.dismiss()
    }
}
