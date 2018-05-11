package com.leanmazzu.brewerydbapp.view.beerstyle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leanmazzu.brewerydbapp.R;
import com.leanmazzu.brewerydbapp.data.remote.Style;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerStyleRecyclerViewAdapter extends RecyclerView.Adapter<BeerStyleRecyclerViewAdapter.ViewHolder> {
	
	private List<Style> items = new ArrayList<>();
	private final OnListFragmentInteractionListener mListener;
	
	public BeerStyleRecyclerViewAdapter(OnListFragmentInteractionListener listener) {
		mListener = listener;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.beer_style_item, parent, false);
		return new ViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		holder.mItem = items.get(position);
		holder.mIdView.setText(items.get(position).getId());
		holder.mContentView.setText(items.get(position).getName());
		
		holder.mView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (null != mListener) {
					// Notify the active callbacks interface (the activity, if the
					// fragment is attached to one) that an item has been selected.
					mListener.onListFragmentInteraction(holder.mItem);
				}
			}
		});
	}
	
	public void setItems(List<Style> items) {
		this.items = items;
		notifyDataSetChanged();
	}
	
	@Override
	public int getItemCount() {
		return items.size();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder {
		public final View mView;
		
		@BindView(R.id.item_number)
		public TextView mIdView;
		@BindView(R.id.content)
		public TextView mContentView;
		public Style mItem;
		
		public ViewHolder(View view) {
			super(view);
			mView = view;
			ButterKnife.bind(this, view);
		}
		
		@Override
		public String toString() {
			return super.toString() + " '" + mContentView.getText() + "'";
		}
	}
	
	public interface OnListFragmentInteractionListener {
		void onListFragmentInteraction(Style item);
	}
}
