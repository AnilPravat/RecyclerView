package myapp.anilandroid.com.recyclerview_demo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private static final int Type_head=0;
    private static final int Type_list=1;



    ArrayList<List_Provider> arrayList = new ArrayList<List_Provider>();
    public RecyclerAdapter(ArrayList<List_Provider> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        RecyclerViewHolder recyclerViewHolder;


        if (viewType==Type_list){
            view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_layout, parent, false );

            recyclerViewHolder = new RecyclerViewHolder( view,viewType );
            return recyclerViewHolder;

        }
        else if (viewType==Type_head){
            view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.head_layout, parent, false );

            recyclerViewHolder = new RecyclerViewHolder( view,viewType );
            return recyclerViewHolder;

        }
       return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        List_Provider list_provider;

        if (holder.view_type==Type_list){
            list_provider = arrayList.get( position -1);
            holder.list_image.setImageResource( list_provider.getImg_id() );
            holder.list_country.setText( list_provider.getCountry() );
            holder.list_capital.setText( list_provider.getCapital() );
        }
        else if (holder.view_type==Type_head){
            holder.title_flag.setText( "FLAG" );
            holder.title_Country.setText( "COUNTRY" );
            holder.title_Capital.setText( "CAPITAL" );

        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size()+1;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        int view_type;

        //variable for list
        ImageView list_image;
        TextView list_country, list_capital;
        //varisble for headsection
        TextView title_flag, title_Country, title_Capital;


        public RecyclerViewHolder(View itemview,int viewtype) {
            super( itemview );

            if (viewtype == Type_list) {
                list_image = (ImageView) itemview.findViewById( R.id.image_flag );
                list_country = (TextView) itemview.findViewById( R.id.tv_country );
                list_capital = (TextView) itemview.findViewById( R.id.tv_capital );
                 view_type=1;

            }
            else if (viewtype == Type_head){
                 title_flag=(TextView) itemview.findViewById( R.id.flag );
                title_Country=(TextView) itemview.findViewById( R.id.country );
                title_Capital=(TextView) itemview.findViewById( R.id.capital );
                view_type=0;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0)
        return Type_head;
        return Type_list;

    }
}
