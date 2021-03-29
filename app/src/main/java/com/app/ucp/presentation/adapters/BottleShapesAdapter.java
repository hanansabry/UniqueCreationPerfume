package com.app.ucp.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.app.ucp.R;
import com.app.ucp.model.BottleShape;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BottleShapesAdapter extends RecyclerView.Adapter<BottleShapesAdapter.BottleShapeViewHolder> {

    public interface BottleShapesClickListener {
        void onBottleClicked(BottleShape bottleShape);
    }

    private List<BottleShape> bottleShapeList;
    private BottleShapesClickListener bottleShapesClickListener;
    private int lastCheckedPosition = -1;

    public BottleShapesAdapter(List<BottleShape> bottleShapeList, BottleShapesClickListener bottleShapesClickListener) {
        this.bottleShapeList = bottleShapeList;
        this.bottleShapesClickListener = bottleShapesClickListener;
    }

    @NonNull
    @Override
    public BottleShapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottle_shape_item, parent, false);
        return new BottleShapeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BottleShapeViewHolder holder, int position) {
        BottleShape bottleShape = bottleShapeList.get(position);
        Picasso.with(holder.itemView.getContext())
                .load(bottleShape.getImageUrl())
                .placeholder(R.drawable.launcher_logo_transparent)
                .into(holder.bottleShapeImageView);

        holder.bottleShapeRadioButton.setChecked(position == lastCheckedPosition);
        holder.bottleShapeRadioButton.setOnClickListener(v -> {
            lastCheckedPosition = position;
            bottleShapesClickListener.onBottleClicked(bottleShape);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return bottleShapeList.size();
    }

    static class BottleShapeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bottleShapeRadioButton)
        RadioButton bottleShapeRadioButton;
        @BindView(R.id.bottleShapeImageView)
        ImageView bottleShapeImageView;

        public BottleShapeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
