package calculator.com.droidconbinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class MyBindingAdapters {

    private static Picasso picasso;

    @BindingAdapter("android:entries")
    public static void setListItems(ListView listView, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(listView.getContext(),
                android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    @BindingAdapter("android:entries")
    public static void setRecyclerViewItems(RecyclerView recyclerView, Person[] persons) {
        PersonAdapter adapter = new PersonAdapter(persons);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter(value = {"android:src", "bind:placeholder", "bind:error"}, requireAll = false)
    public static void downloadImage(ImageView imageView, String downloadUrl,
                                     Drawable placeholderDrawable, Drawable errorDrawable) {

        Picasso picasso = getPicassoInstance(imageView.getContext());
        RequestCreator requestCreator = picasso.load(downloadUrl);
        if (placeholderDrawable != null) {
            requestCreator.placeholder(placeholderDrawable);
        }
        if (errorDrawable != null) {
            requestCreator.error(errorDrawable);
        }
        requestCreator
                .fit()
                .into(imageView);
    }

    private static Picasso getPicassoInstance(Context context) {
        if (picasso == null) {
            picasso = Picasso.with(context);
        }
        return picasso;
    }
}
