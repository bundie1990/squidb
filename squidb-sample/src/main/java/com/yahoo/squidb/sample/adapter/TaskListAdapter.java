/*
 * Copyright 2015, Yahoo Inc.
 * Copyrights licensed under the Apache 2.0 License.
 * See the accompanying LICENSE file for terms.
 */
package com.yahoo.squidb.sample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahoo.squidb.sample.R;
import com.yahoo.squidb.sample.models.Task;
import com.yahoo.squidb.sample.utils.TaskUtils;
import com.yahoo.squidb.utility.SquidCursorAdapter;

public class TaskListAdapter extends SquidCursorAdapter<Task> {

    public TaskListAdapter(Context context, Task model) {
        super(context, model);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.task_row, null);
            convertView.setTag(new TaskRowViewHolder(convertView));
        }

        TaskRowViewHolder viewHolder = (TaskRowViewHolder) convertView.getTag();

        Task item = getItem(position);
        viewHolder.taskTitle.setText(item.getTitle());
        viewHolder.taskTags.setText(item.get(TaskUtils.TAGS_CONCAT));
        return convertView;
    }

    private static class TaskRowViewHolder {

        TextView taskTitle;
        TextView taskTags;

        public TaskRowViewHolder(View row) {
            taskTitle = (TextView) row.findViewById(R.id.task_title);
            taskTags = (TextView) row.findViewById(R.id.task_tags);
        }
    }
}
