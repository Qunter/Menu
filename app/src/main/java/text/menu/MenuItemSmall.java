package text.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MenuItemSmall extends LinearLayout {
    private ImageView imageView;
    private TextView textView;
    public MenuItemSmall(Context context) {
        super(context);
    }
    public MenuItemSmall(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.menu_item_small,this);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
    }
    public void setTextViewText(String text){
        textView.setText(text);
    }
    public void setImageViewImg(int resId){
        imageView.setImageResource(resId);
    }
    public void setTextViewColor(int color){
        textView.setTextColor(color);
    }
    public void setTextsize(int size){
        textView.setTextSize(size);
    }
}
