package dev.x001.testprojectnativeandroid.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.x001.testprojectnativeandroid.databinding.ItemLogBinding
import dev.x001.testprojectnativeandroid.model.entity.LogRecord

class LogsAdapter(): RecyclerView.Adapter<LogsAdapter.ViewHolder>() {

    private var logs = listOf<LogRecord>()

    inner class ViewHolder(binding: ItemLogBinding):
    RecyclerView.ViewHolder(binding.root){
        val eventTextView = binding.eventTextView
        val timestampTextView = binding.timestampTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemLogBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: LogRecord = logs[position]
        holder.eventTextView.text = model.event
        holder.timestampTextView.text = model.timestamp
    }

    fun setLogs(list: List<LogRecord>){
        logs = list
        notifyDataSetChanged()
    }
}