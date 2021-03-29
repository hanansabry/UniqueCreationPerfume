package com.app.ucp.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.ucp.R;
import com.app.ucp.model.PerfumeRequest;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfumeRequestsAdapter extends RecyclerView.Adapter<PerfumeRequestsAdapter.PerfumeRequestViewHolder> {

    public interface PerfumeRequestClickListener {
        void onPerfumeRequestClicked(PerfumeRequest perfumeRequest);
    }

    private List<PerfumeRequest> perfumeRequestList;
    private PerfumeRequestClickListener clickListener;

    public PerfumeRequestsAdapter(List<PerfumeRequest> perfumeRequestList, PerfumeRequestClickListener clickListener) {
        this.perfumeRequestList = perfumeRequestList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PerfumeRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_item, parent, false);
        return new PerfumeRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfumeRequestViewHolder holder, int position) {
        PerfumeRequest perfumeRequest = perfumeRequestList.get(position);
        holder.phoneTextView.setText(perfumeRequest.getPhoneNumber());
        holder.perfumeTextView.setText(perfumeRequest.getPerfume().getFragranceFamily().getPerfume());
        holder.priceTextView.setText(String.valueOf(perfumeRequest.getPerfume().getPrice()));
        holder.content.setOnClickListener(v -> clickListener.onPerfumeRequestClicked(perfumeRequest));
    }

    @Override
    public int getItemCount() {
        return perfumeRequestList.size();
    }

    class PerfumeRequestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.phoneTextView)
        TextView phoneTextView;
        @BindView(R.id.perfumeTextView)
        TextView perfumeTextView;
        @BindView(R.id.priceTextView)
        TextView priceTextView;
        @BindView(R.id.content)
        View content;

        public PerfumeRequestViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
