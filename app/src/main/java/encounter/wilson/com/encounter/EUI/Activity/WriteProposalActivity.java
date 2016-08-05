package encounter.wilson.com.encounter.EUI.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import encounter.wilson.com.encounter.EUI.FlowRadioGroup;
import encounter.wilson.com.encounter.R;

public class WriteProposalActivity extends BaseActivity implements View.OnClickListener {
    FlowRadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_proposal);
        initView();
    }

    private void initView() {
        findViewById(R.id.write_proposal_cancel).setOnClickListener(this);
        findViewById(R.id.write_proposal_finish).setOnClickListener(this);
        findViewById(R.id.write_proposal_add).setOnClickListener(this);
        rg = (FlowRadioGroup) findViewById(R.id.write_proposa_radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //取消
            case R.id.write_proposal_cancel:
                finish();
                break;
            //弹出发表建议dialog
            case R.id.write_proposal_finish:
                showDialog();
                break;
            //添加标签
            case R.id.write_proposal_add:
                addTags("new tags");
                break;
            //发表
            case R.id.write_dialog_finish:
                dialog.dismiss();
                break;
            case R.id.write_dialog_cancel:
                dialog.dismiss();
                break;
        }
    }

    Dialog dialog = null;

    private void showDialog() {
        if (dialog == null) {
            dialog = new Dialog(this, R.style.Translucent_NoTitle);
            View v = View.inflate(this, R.layout.write_dialog, null);
            v.findViewById(R.id.write_dialog_finish).setOnClickListener(this);
            v.findViewById(R.id.write_dialog_cancel).setOnClickListener(this);
            dialog.setContentView(v);
            dialog.setCanceledOnTouchOutside(true);
            // 设置宽度为屏宽、靠近屏幕底部。
            Window window = dialog.getWindow();
            WindowManager.LayoutParams wlp = window.getAttributes();
            wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
            wlp.gravity = Gravity.BOTTOM;
            window.setAttributes(wlp);
        }
        dialog.show();
    }

    //添加新标签
    private void addTags(String str) {
        CheckBox ck = (CheckBox) View.inflate(this, R.layout.my_check_box, null);
        ck.setText(str);
        rg.addView(ck);
    }
}
