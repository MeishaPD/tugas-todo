package pam.example.pamasinkron01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.VH> {

    private List<Todo> todoList;

    public Adapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public class VH extends RecyclerView.ViewHolder {

        private TextView tvWhat, tvTime;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.tvWhat = itemView.findViewById(R.id.tvWhat);
            this.tvTime = itemView.findViewById(R.id.tvTime);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new VH(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Todo todo = this.todoList.get(position);
        holder.tvWhat.setText(todo.getWhat().toString());
        holder.tvTime.setText(todo.getTime().toString());
    }

    @Override
    public int getItemCount() {
        return this.todoList.size();
    }
}
