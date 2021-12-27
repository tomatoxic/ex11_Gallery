package com.example.ex11_gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = findViewById(R.id.gallery1);
        MyGalleryAdapter galleyAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galleyAdapter);
    }

    // ALT + INSERT - Implements Method로 아래 4개의 추상메소드 자동생성
    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
                R.drawable.mov14, R.drawable.mov15, R.drawable.mov16, R.drawable.mov17,
                R.drawable.mov18, R.drawable.mov19, R.drawable.mov20};

        String[] posterName = {
                "여인의 향기", "쥬라기공원", "포레스트검프", "그라운드호그데이", "혹성탈출",
                "아름다운비행", "내이름은 칸", "이제 모든 것이 끝난다", "마더", "킹콩을 들다" };

        public MyGalleryAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(posterID[i]);

            final int pos = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView ivPoster = findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    // 토스트 출력
                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast1, (ViewGroup) findViewById(R.id.toast_layout));

                    TextView txtView1 = (TextView) toastView.findViewById(R.id.txtView1);
                    txtView1.setText(posterName[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(toastView);
                    toast.show();
                }
            });
            return imageView;
        }
    }
}