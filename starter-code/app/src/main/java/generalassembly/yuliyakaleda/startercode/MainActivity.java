package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mAddButton;
    private Button mDeleteButton;
    private TextView mTextView;
    private ListView mListView;
    private BaseAdapter mListAdapter;

    private ArrayList<String> wishes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: set up all the view and event listeners.
        mEditText = (EditText) findViewById(R.id.edit_text);
        mAddButton = (Button) findViewById(R.id.add_button);
        mDeleteButton = (Button) findViewById(R.id.delete_button);
        mTextView = (TextView) findViewById(R.id.new_item_name);
        mListView = (ListView) findViewById(R.id.wish_list);

        wishes = new ArrayList<>();
        mListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wishes);

        mListView.setAdapter(mListAdapter);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mEditText.getText().toString());
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
                mTextView.startAnimation(anim);
                wishes.add(mEditText.getText().toString());

                mListAdapter.notifyDataSetChanged();
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wishes.remove(mEditText.getText().toString())) {
                    mEditText.setError("This wish does not exist!");
                }
                else {
                    mTextView.setText(mEditText.getText().toString());
                    Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.remove_animation);
                    mTextView.startAnimation(anim);

                    mListAdapter.notifyDataSetChanged();
                }
            }
        });

    }

//    @Override
//    public void onClick(View v) {
//        // TODO: 1. get the text from the input field
//        //       2. animate it in the center of the screen
//        //       3. add it to the list wish
//        //       4. clear the input field
//      }
}
