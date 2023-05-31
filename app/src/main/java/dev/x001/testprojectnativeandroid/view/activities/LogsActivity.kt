package dev.x001.testprojectnativeandroid.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dev.x001.testprojectnativeandroid.application.LogApplication
import dev.x001.testprojectnativeandroid.databinding.ActivityLogsBinding
import dev.x001.testprojectnativeandroid.view.adapter.LogsAdapter
import dev.x001.testprojectnativeandroid.viewmodel.LogViewModel
import dev.x001.testprojectnativeandroid.viewmodel.LogViewModelFactory

class LogsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogsBinding

    private val mLogViewModel: LogViewModel by viewModels {
        LogViewModelFactory((this.application as LogApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val logsAdapter = LogsAdapter()
        binding.logsRecyclerView.adapter = logsAdapter

        mLogViewModel.allLogRecordList.observe(this@LogsActivity){
            logs ->
            if (logs.isNotEmpty()){
                logsAdapter.setLogs(logs)
            }
        }
    }
}