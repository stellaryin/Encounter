package encounter.wilson.com.encounter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joooonho.SelectableRoundedImageView;

import java.util.ArrayList;
import java.util.List;

import encounter.wilson.com.encounter.DTO.Pictrue;
import encounter.wilson.com.encounter.R;
import encounter.wilson.com.encounter.listener.RecyclerViewOnItemClickListener;

/**
 * Created by xiaoqiang on 16/7/31.
 */
public class PicWallAdapter extends RecyclerView.Adapter<PicWallAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Pictrue> dataList;
    private static RecyclerViewOnItemClickListener itemClickListener;
    public PicWallAdapter(Context context, ArrayList<Pictrue> dataLsit) {
        this.context = context;
        this.dataList = dataLsit;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_content_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.OnItemClick((Integer) view.getTag());
                }
            }
        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(dataList.get(position).getTestpic());

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public void setOnItemClick(RecyclerViewOnItemClickListener clickListener) {
        itemClickListener = clickListener;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private SelectableRoundedImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            imageView = (SelectableRoundedImageView) itemView.findViewById(R.id.masonry_item_img);
            imageView.setCornerRadiiDP(10, 10, 0, 0);
        }
    }
}
