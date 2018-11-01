package com.wwwjf.demo.costomView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wwwjf.demo.R;


public class LabelView extends HorizontalScrollView {
    private View itemView;
    private RelativeLayout mLayoutContent;
    private EditText mEditTextContent;
    private TextView mTextViewContent;
    private ImageView mImageViewDelete;
    private ImageView mImageViewAdd;

    public LabelView(Context context) {
        super(context);
        init(context);
    }

    public LabelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        addItem(context);
    }

    private void addItem(final Context context) {
        itemView = LayoutInflater.from(context).inflate(R.layout.widget_label_view, this);
        mLayoutContent = itemView.findViewById(R.id.layout_label_name);
        mEditTextContent = itemView.findViewById(R.id.editText_label_name);
        mTextViewContent = itemView.findViewById(R.id.textView_label_name);
        mImageViewDelete = itemView.findViewById(R.id.imageView_label_delete);
        mImageViewAdd = itemView.findViewById(R.id.layout_label_add);
        mEditTextContent.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.ACTION_DOWN != event.getAction())
                    return false;
                switch (keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        break;

                    default:
                        break;
                }
                return false;
            }
        });
        mImageViewAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加item
                addItem(context);
            }
        });

        mLayoutContent.setVisibility(GONE);
        mImageViewAdd.setVisibility(VISIBLE);

        this.addView(itemView);
    }

}
