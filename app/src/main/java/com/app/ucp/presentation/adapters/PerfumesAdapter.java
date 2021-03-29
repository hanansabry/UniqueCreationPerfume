package com.app.ucp.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.ucp.R;
import com.app.ucp.model.Perfume;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfumesAdapter extends RecyclerView.Adapter<PerfumesAdapter.PerfumeViewHolder> {

    public interface PerfumeClickListener {
        void onPerfumeClicked(Perfume perfume);
    }

    private List<Perfume> perfumeList;
    private PerfumeClickListener perfumeClickListener;

    public PerfumesAdapter(List<Perfume> perfumeList, PerfumeClickListener perfumeClickListener) {
        this.perfumeList = perfumeList;
        this.perfumeClickListener = perfumeClickListener;
    }

    @NonNull
    @Override
    public PerfumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perfume_item_layout, parent, false);
        return new PerfumeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfumeViewHolder holder, int position) {
        Perfume perfume = perfumeList.get(position);
        holder.perfumeNameTextView.setText(perfume.getFragranceFamily().getPerfume());
        holder.perfumeLayout.setOnClickListener(v -> perfumeClickListener.onPerfumeClicked(perfume));
    }

    @Override
    public int getItemCount() {
        return perfumeList.size();
    }

    class PerfumeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.perfumeNameTextView)
        TextView perfumeNameTextView;
        @BindView(R.id.perfumeLayout)
        View perfumeLayout;

        public PerfumeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
