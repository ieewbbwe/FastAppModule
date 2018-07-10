package debug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mobile_core.module_personal.main.MineActivity;

/**
 * Created by picher on 2018/7/5.
 * Describe：
 */
public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在这里传值给需要调试的Activity
        Intent intent = new Intent(this, MineActivity.class);
        intent.putExtra("id", "9500116");
        startActivity(intent);
        finish();
    }

}
