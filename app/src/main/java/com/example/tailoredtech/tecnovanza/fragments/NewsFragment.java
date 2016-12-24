package com.example.tailoredtech.tecnovanza.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.tecnovanza.R;
import com.example.tailoredtech.tecnovanza.adapter.NewsAdapter;
import com.example.tailoredtech.tecnovanza.model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    String newsjson =
            "[\n" +
                    "    {\n" +
                    "        \"description\": \"Android 7.0–7.1.1 Nougat (codenamed Android N during development)[4] is the seventh major version of the Android operating system. First released as a beta build on March 9, 2016,[5] it was officially released on August 22, 2016, with Nexus devices being the first to receive the update, though the LG V20 was the first new smartphone released with Nougat. Nougat introduces notable changes to the operating system and its development platform, including the ability to display multiple apps on-screen at once in a split-screen view, support for inline replies to notifications, as well as an OpenJDK-based Java environment and support for the Vulkan graphics rendering API, and seamless system updates on supported devices.\",\n" +
                    "        \"name\": \"Android Nougat\",\n" +
                    "        \"city\": \"7.0\",\n" +
                    "        \"time\": \"August 2016\",\n" +
                    "        \"comments\": \"Latest release 7.1.1\",\n" +
                    "        \"img\": \"http://wefix.co.za/wp-content/uploads/2016/08/android-nougat-1.jpg\",\n" +
                    "        \"pimg\": \"https://lh3.googleusercontent.com/-B7ObxLWBsRU/AAAAAAAAAAI/AAAAAAAAW_w/VGt2B9ZL1k4/s46-c-k-no/photo.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"description\": \"Android 6.0 – 6.0.1 Marshmallow (codenamed Android M during development)[3] is the 6th major version of the Android operating system. First unveiled in May 2015 at Google I/O, it was officially released in October 2015.\",\n" +
                    "        \"name\": \"Android Marshmallow\",\n" +
                    "        \"city\": \"6.0\",\n" +
                    "        \"time\": \"October 2015\",\n" +
                    "        \"comments\": \"Latest release 6.0.1\",\n" +
                    "        \"img\": \"http://www.itmlab.com/wp-content/uploads/2015/10/android-6-marshmallow-banner-hiddenbrains-twitter.jpg\",\n" +
                    "        \"pimg\": \"https://pbs.twimg.com/profile_images/937374385/Mark_Zuckerberg_szykuja_3268108_normal.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"description\": \"Android 5.0–5.1.1 Lollipop is a version of the Android mobile operating system developed by Google, spanning versions between 5.0 and 5.1.1. Unveiled on June 25, 2014 at the Google I/O 2014 conference, it became available through official over-the-air (OTA) updates on November 12, 2014, for select devices that run distributions of Android serviced by Google (such as Nexus and Google Play edition devices). Its source code was made available on November 3, 2014\",\n" +
                    "        \"name\": \"Android Lollipop\",\n" +
                    "        \"city\": \"5.0\",\n" +
                    "        \"time\": \"July 2014\",\n" +
                    "        \"comments\": \"Latest release 5.1.1\",\n" +
                    "        \"img\": \"http://i2.wp.com/www.thegadgetmasters.com/wp-content/uploads/2014/11/lolli-820x420.jpg\",\n" +
                    "        \"pimg\": \"https://lh3.googleusercontent.com/-Y86IN-vEObo/AAAAAAAAAAI/AAAAAAAKyAM/6bec6LqLXXA/s46-c-k-no/photo.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"description\": \"Android 4.4–4.4.4 KitKat is a version of the Android mobile operating system developed by Google, spanning versions between 4.4 and 4.4.4. Unveiled on September 3, 2013, KitKat focused primarily on optimizing the operating system for improved performance on entry-level devices with limited resources.\",\n" +
                    "        \"name\": \"Android KitKat\",\n" +
                    "        \"city\": \"4.4\",\n" +
                    "        \"time\": \"September 2013\",\n" +
                    "        \"comments\": \"Latest release 4.4.4\",\n" +
                    "        \"img\": \"http://panama-me.com/wp-content/uploads/2009/09/Kitkat-banner.JPG\",\n" +
                    "        \"pimg\": \"http://cdn.images.express.co.uk/img/dynamic/galleries/64x64/97537.jpg\"\n" +
                    "    }\n" +
                    "]";

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        JSONArray news=null;
        try {
            news=new JSONArray(newsjson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<News> newsList=getNewsList(news);

        RecyclerView newsRecycler = (RecyclerView) view.findViewById(R.id.news_list);

        NewsAdapter adapter = new NewsAdapter(new ArrayList<String>());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        newsRecycler.setLayoutManager(manager);
        newsRecycler.setAdapter(adapter);

        return view;
    }

    private ArrayList<News> getNewsList(JSONArray news) {
        ArrayList<News> newsList=new ArrayList<>();
        for(int i = 0; i < news.length(); i++)
        {
            JSONObject newsObj = news.optJSONObject(i);
            if(newsObj!=null)
            {
                newsList.add(News.initialiseFromJSON(newsObj));
            }
        }
        return newsList;
    }

}
