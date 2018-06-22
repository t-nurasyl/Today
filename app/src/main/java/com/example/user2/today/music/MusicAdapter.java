package com.example.user2.today.music;

import android.content.Context;
        import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Adapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.user2.today.R;
import com.example.user2.today.fragment.MusicFragment;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {
    private Context mContext;
    private List<Track> track;
    TextView nameOfMovie,plotSynopsis,userRating ,releaseDate;
    ImageView imageView;
    ToggleButton addToWatchList;
//    Track track;

    public MusicAdapter(Context mContext, List<Track> tracks){
        this.track = tracks;
        this.mContext = mContext;
    }

    public MusicAdapter(FragmentManager supportFragmentManager) {

    }

    @Override
    public MusicAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_music,viewGroup,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MusicAdapter.MyViewHolder viewHolder,int i){
        viewHolder.title.setText(track.get(i).getName());
        String vote = track.get(i).getDuration();
        viewHolder.userrating.setText(vote);
//        String url = track.get(i).getImage();
        //Log.d("idiiiiiii",url);
//        Glide.with(mContext).load(url)
//                .placeholder(R.drawable.load)
//                .dontAnimate()
//                .into(viewHolder.thumbnail);
    }
    @Override
    public int getItemCount(){
        return track.size();
    }

    public void addFragment(MusicFragment tf1, String one) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,userrating;
        ImageView thumbnail;

        public  MyViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
//            userrating = (TextView)view.findViewById(R.id.userrating);
//            thumbnail = (ImageView)view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos =getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        Track clickedDataItem = track.get(pos);
                        Intent intent =new Intent(mContext, MusicFragment.class);
                        intent.putExtra("music",clickedDataItem);

                        intent.putExtra("name",clickedDataItem.getName());
                        intent.putExtra("duration",clickedDataItem.getDuration());
                        intent.putExtra("listeners",clickedDataItem.getListeners());
                        intent.putExtra("mbid",clickedDataItem.getMbid());
                        intent.putExtra("playcount",clickedDataItem.getPlaycount());
                        intent.putExtra("url",clickedDataItem.getUrl());
                        intent.putExtra("artist", (Parcelable) clickedDataItem.getArtist());
                        intent.putExtra("streamable", (Parcelable) clickedDataItem.getStreamable());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        //Toast.makeText(v.getContext(),"Clicked "+clickedDataItem.getOriginalTitle(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
