package com.task.covidtrack.Adapter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.task.covidtrack.Model.Country;
import com.task.covidtrack.R;

import java.util.ArrayList;
import java.util.List;

public class RawDataAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "RawAdapter";
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<Country> mRawList;
    private List<Country> exampleList;

    public RawDataAdapter(List<Country> rawList) {
        this.exampleList=rawList;
        mRawList = rawList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_item, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mRawList != null && mRawList.size() > 0) {
            return mRawList.size();
        } else {
            return 0;
        }
    }

    public Filter getFilter(){
        return exampleFilter;
    }

    public class ViewHolder extends BaseViewHolder {
        TextView ivCity;
        TextView tvConfirm;
        TextView tvRecover;
        TextView tvDeath;
        LinearLayout data_size;
        public ViewHolder(View itemView) {
            super(itemView);
            ivCity = itemView.findViewById(R.id.city);
            tvConfirm = itemView.findViewById(R.id.tvconfirm);
            tvRecover = itemView.findViewById(R.id.tvrecover);
            tvDeath = itemView.findViewById(R.id.tvdeath);
            data_size=itemView.findViewById(R.id.data_size);

        }
        public void onBind(int position) {
            super.onBind(position);

            final Country mRaw = mRawList.get(position);

            String icon="\n"+"↑";

            if (mRaw.getCountry() != null) {
                ivCity.setText(mRaw.getCountry());
            }

            if (mRaw.getTotalConfirmed() != null) {
                SpannableStringBuilder builder1 = new SpannableStringBuilder();
                String first1= mRaw.getTotalConfirmed().toString();
                String second1=mRaw.getNewConfirmed().toString();
                String all1=icon+second1;
                SpannableString blueSpannable = new SpannableString(all1);
                blueSpannable.setSpan(new ForegroundColorSpan(Color.parseColor("#DA2013")), 0, all1.length(), 0);
                if (second1.equals("0")){
                    builder1.append(first1);
                    tvConfirm.setText(first1);
                }else {
                    builder1.append(first1);
                    builder1.append(blueSpannable);
                    tvConfirm.setText(builder1, TextView.BufferType.SPANNABLE);
                }
            }

            if (mRaw.getTotalRecovered() != null) {
                SpannableStringBuilder builder2 = new SpannableStringBuilder();
                String first2= mRaw.getTotalRecovered().toString();
                String second2=mRaw.getNewRecovered().toString();
                String all2=icon+second2;
                SpannableString blueSpannable = new SpannableString(all2);
                blueSpannable.setSpan(new ForegroundColorSpan(Color.parseColor("#348737")), 0, all2.length(), 0);
                if (second2.equals("0")){
                    builder2.append(first2);
                    tvRecover.setText(first2);
                }else {
                    builder2.append(first2);
                    builder2.append(blueSpannable);
                    tvRecover.setText(builder2, TextView.BufferType.SPANNABLE);
                }
            }
            if (mRaw.getTotalDeaths() != null) {
                SpannableStringBuilder builder3 = new SpannableStringBuilder();
                String first3= mRaw.getTotalDeaths().toString();
                String second3=mRaw.getNewDeaths().toString();
                String all3=icon+second3;
                SpannableString blueSpannable = new SpannableString(all3);
                blueSpannable.setSpan(new ForegroundColorSpan(Color.parseColor("#E8AE00")), 0, all3.length(), 0);
                if (second3.equals("0")){
                    builder3.append(first3);
                    tvDeath.setText(first3);
                }else {
                    builder3.append(first3);
                    builder3.append(blueSpannable);
                    tvDeath.setText(builder3, TextView.BufferType.SPANNABLE);
                }
            }

//            tvLink.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mRaw.getSource2() != null) {
//                        try {
//                            Intent intent = new Intent();
//                            intent.setAction(Intent.ACTION_VIEW);
//                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                            intent.setData(Uri.parse(mRaw.getSource2()));
//                            itemView.getContext().startActivity(intent);
//                        } catch (Exception e) {
//                            Log.e(TAG, "onClick: Image url is not correct");
//                        }
//                    }
//                }
//            });
        }
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Country> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mRawList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Country item : mRawList) {
                    if (item.getCountry().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}