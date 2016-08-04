package encounter.wilson.com.encounter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/2.
 */
public class BaseActivity extends Activity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }


    public void showToast(String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
