package text.menu;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //定义一级菜单中的四个Item的名称以及资源
    private MenuItem qiwei,yule,qipao,anquan;
    private String[] MenuItemName = {"气味","娱乐","气泡","安全"};
    private int[] MenuItemIcon = {R.drawable.ic_speaker_notes_white_36dp,R.drawable.ic_star_border_white_36dp,R.drawable.ic_timeline_white_36dp,R.drawable.ic_security_white_36dp};
    private int[] MenuItemIconChange = {R.drawable.ic_speaker_notes_blue_500_36dp,R.drawable.ic_star_border_blue_500_36dp,R.drawable.ic_timeline_blue_500_36dp,R.drawable.ic_security_blue_500_36dp};
    //定义二级菜单中的四个Item的名称以及资源
    private MenuItemSmall shangpu,tanwei,huodong,qunliao;
    private String[] MenuItemSmallName = {"商铺","摊位","活动","群聊"};
    private int[] MenuItemSmallIcon = {R.drawable.ic_store_mall_directory_white_24dp,R.drawable.ic_pin_drop_white_24dp,R.drawable.ic_redeem_white_24dp,R.drawable.ic_people_outline_white_24dp};
    private int[] MenuItemSmallIconChange = {R.drawable.ic_store_mall_directory_blue_500_24dp,R.drawable.ic_pin_drop_blue_500_24dp,R.drawable.ic_redeem_blue_500_24dp,R.drawable.ic_people_outline_blue_500_24dp};
    //定义文字颜色的两种变换，未按下是白色，按下是蓝色
    private int textColor = Color.parseColor("#ffffff");
    private int textColorChange = Color.parseColor("#2196f3");
    //定义一二级菜单MSG的信息，按下哪个发送哪条
    private final int QIWEI=0x00,YULE=0x01,QIPAO=0x02,ANQUAN=0x03;
    private final int SHANGPU=0x04,TANWEI=0x05,HUODONG=0x06,QUNLIAO=0x07;
    //用于判断二级菜单的显示状况，true为显示，false为隐藏
    private boolean level2ListPlay = false;
    //二级菜单
    private RelativeLayout level2_Rl;
    //用于记录有多少个动画在执行
    private int annimationCount = 0;
    //用于恢复被点击按钮的颜色
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                //一级菜单
                case QIWEI:
                    qiwei.setImageViewImg(MenuItemIcon[0]);
                    qiwei.setTextViewColor(textColor);
                    break;
                case YULE:
                    yule.setImageViewImg(MenuItemIcon[1]);
                    yule.setTextViewColor(textColor);
                    break;
                case QIPAO:
                    if(level2ListPlay){
                        qipao.setImageViewImg(MenuItemIconChange[2]);
                        qipao.setTextViewColor(textColorChange);
                    }else{
                        qipao.setImageViewImg(MenuItemIcon[2]);
                        qipao.setTextViewColor(textColor);
                    }
                    break;
                case ANQUAN:
                    anquan.setImageViewImg(MenuItemIcon[3]);
                    anquan.setTextViewColor(textColor);
                    break;
                //二级菜单
                case SHANGPU:
                    shangpu.setImageViewImg(MenuItemSmallIcon[0]);
                    shangpu.setTextViewColor(textColor);
                    break;
                case TANWEI:
                    tanwei.setImageViewImg(MenuItemSmallIcon[1]);
                    tanwei.setTextViewColor(textColor);
                    break;
                case HUODONG:
                    huodong.setImageViewImg(MenuItemSmallIcon[2]);
                    huodong.setTextViewColor(textColor);
                    break;
                case QUNLIAO:
                    qunliao.setImageViewImg(MenuItemSmallIcon[3]);
                    qunliao.setTextViewColor(textColor);
                    break;
            }
            super.handleMessage(msg);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    //初始化组件
    private void initView() {

        level2_Rl = (RelativeLayout) findViewById(R.id.level2_Rl);
        level2_Rl.setVisibility(View.INVISIBLE);//先将列表隐藏
        initMenuItem();
        initMenuSmallItem();



    }

    //初始化一级菜单
    private void initMenuSmallItem(){
        qiwei = (MenuItem) findViewById(R.id.qiwei);
        qiwei.setImageViewImg(MenuItemIcon[0]);
        qiwei.setTextViewText(MenuItemName[0]);
        qiwei.setOnClickListener(this);

        yule = (MenuItem) findViewById(R.id.yule);
        yule.setImageViewImg(MenuItemIcon[1]);
        yule.setTextViewText(MenuItemName[1]);
        yule.setOnClickListener(this);

        qipao = (MenuItem) findViewById(R.id.qipao);
        qipao.setImageViewImg(MenuItemIcon[2]);
        qipao.setTextViewText(MenuItemName[2]);
        qipao.setOnClickListener(this);

        anquan = (MenuItem) findViewById(R.id.anquan);
        anquan.setImageViewImg(MenuItemIcon[3]);
        anquan.setTextViewText(MenuItemName[3]);
        anquan.setOnClickListener(this);
    }
    //初始化二级菜单Item
    private void initMenuItem(){
        shangpu = (MenuItemSmall) findViewById(R.id.shangpu);
        shangpu.setImageViewImg(MenuItemSmallIcon[0]);
        shangpu.setTextViewText(MenuItemSmallName[0]);
        shangpu.setOnClickListener(this);

        tanwei = (MenuItemSmall) findViewById(R.id.tanwei);
        tanwei.setImageViewImg(MenuItemSmallIcon[1]);
        tanwei.setTextViewText(MenuItemSmallName[1]);
        tanwei.setOnClickListener(this);

        huodong = (MenuItemSmall) findViewById(R.id.huodong);
        huodong.setImageViewImg(MenuItemSmallIcon[2]);
        huodong.setTextViewText(MenuItemSmallName[2]);
        huodong.setOnClickListener(this);

        qunliao = (MenuItemSmall) findViewById(R.id.qunliao);
        qunliao.setImageViewImg(MenuItemSmallIcon[3]);
        qunliao.setTextViewText(MenuItemSmallName[3]);
        qunliao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qiwei:
                qiwei.setImageViewImg(MenuItemIconChange[0]);
                qiwei.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(QIWEI,300);
                break;
            case R.id.yule:
                yule.setImageViewImg(MenuItemIconChange[1]);
                yule.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(YULE,300);
                break;
            case R.id.qipao:
                showList();
                mHandler.sendEmptyMessage(QIPAO);
                break;
            case R.id.anquan:
                anquan.setImageViewImg(MenuItemIconChange[3]);
                anquan.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(ANQUAN,300);
                break;
            case R.id.shangpu:
                shangpu.setImageViewImg(MenuItemSmallIconChange[0]);
                shangpu.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(SHANGPU,300);
                break;
            case R.id.tanwei:
                tanwei.setImageViewImg(MenuItemSmallIconChange[1]);
                tanwei.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(TANWEI,300);
                break;
            case R.id.huodong:
                huodong.setImageViewImg(MenuItemSmallIconChange[2]);
                huodong.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(HUODONG,300);
                break;
            case R.id.qunliao:
                qunliao.setImageViewImg(MenuItemSmallIconChange[3]);
                qunliao.setTextViewColor(textColorChange);
                mHandler.sendEmptyMessageDelayed(QUNLIAO,300);
                break;
        }
    }
    //点击一级菜单中气泡后先是列表的方法
    private void showList() {
        //当点击的时候就可以进行判断，只要annimationCount值大于0，说明还有动画在执行，不进行操作
        if (annimationCount > 0) {
            return ;
        }
        //二级级菜单显示，就将二级菜单隐藏掉
        if (level2ListPlay) {
            //将二级菜单隐藏，并改变标记
            hideMenu(level2_Rl,300);
            level2ListPlay = false;
            return;
        }
        //二级菜单不显示的时候，就将二级菜单显示
        if (!level2ListPlay) {
            showMenu(level2_Rl);
            level2ListPlay = true;
            return;
        }

    }
    /**
     * 显示菜单
     * @param view  要显示的菜单
     */
    private void showMenu(RelativeLayout view) {
//		view.setVisibility(View.VISIBLE);
        //如果要显示菜单，那么就将相应的控件设为有焦点
        //获取父容器中有几个子控件
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(true);
        }
        //动画集
        AnimationSet animSet = new AnimationSet(true);
        //渐变动画
        AlphaAnimation alphAnim = new AlphaAnimation(0,1);
        animSet.addAnimation(alphAnim);
        //旋转动画
        RotateAnimation rotaAnim = new RotateAnimation(-45, 0, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animSet.addAnimation(rotaAnim);
        animSet.setDuration(500);
        animSet.setFillAfter(true);//动画停留在动画结束的位置
        view.startAnimation(animSet);
        animSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始的时候回调
                annimationCount ++;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画执行过程调用
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束的时候调用
                annimationCount --;
            }
        });
    }
    /**
     * 隐藏菜单
     * @param view  要隐藏的菜单 ,startOffset 动画延迟执行的时间
     */
    private void hideMenu(RelativeLayout view,long startOffset) {
//		view.setVisibility(View.GONE);
        //如果要隐藏菜单，那么就将相应的控件设为没有焦点
        //获取父容器中有几个子控件
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(false);
        }
        /**
         * 旋转动画
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue)
         * fromDegrees 开始旋转角度
         * toDegrees 旋转的结束角度
         * pivotXType X轴 参照物 （X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF）
         * pivotXValue x轴 旋转的参考点（x坐标的伸缩值）
         * pivotYType Y轴 参照物 （Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF）
         * pivotYValue Y轴 旋转的参考点 (（Y坐标的伸缩值） )
         */
        //动画集
        AnimationSet animSet = new AnimationSet(true);
        //渐变动画
        AlphaAnimation alphAnim = new AlphaAnimation(1,0);
        animSet.addAnimation(alphAnim);
        //旋转动画
        RotateAnimation rotaAnim = new RotateAnimation(0, 45, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animSet.addAnimation(rotaAnim);
        animSet.setDuration(500);
        animSet.setFillAfter(true);//动画停留在动画结束的位置
        animSet.setStartOffset(startOffset);		//设置动画的延迟执行
        view.startAnimation(animSet);
        animSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                annimationCount ++;
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                annimationCount --;
            }
        });
    }
}
