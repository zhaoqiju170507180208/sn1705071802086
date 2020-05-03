package cn.edu.sdwu.android02.home.sn170507180208;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class homework2 extends AppCompatActivity {
    private HomeworkOpenHelper homeworkOpenHelper;
    private EditText editText1,editText2,editText3,editText4;
    private Button insert,showall,clearshow,deleteall,IDdelete,IDupdate,IDselect;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homework2);

        homeworkOpenHelper=new HomeworkOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=homeworkOpenHelper.getWritableDatabase();
        sqLiteDatabase.close();

        editText1=(EditText)findViewById(R.id.name);
        editText2=(EditText)findViewById(R.id.age);
        editText3=(EditText)findViewById(R.id.height);
        editText4=(EditText)findViewById(R.id.IDnumber);

        insert=(Button) findViewById(R.id.insert);
        showall=(Button) findViewById(R.id.showall);
        clearshow=(Button) findViewById(R.id.clearshow);
        deleteall=(Button) findViewById(R.id.deleteall);
        IDdelete=(Button) findViewById(R.id.IDdelete);
        IDselect=(Button) findViewById(R.id.IDselect);
        IDupdate=(Button) findViewById(R.id.IDupdate);


    }

    public void insert(View view){
        String name=editText1.getText().toString();
        String age=editText2.getText().toString();
        String height=editText2.getText().toString();
        SQLiteDatabase sqLiteDatabase=homeworkOpenHelper.getWritableDatabase();

       try{
           if(name.equals(null)){
               Toast.makeText(homework2.this,"姓名不能为空！",Toast.LENGTH_SHORT).show();
           }else {
               sqLiteDatabase.beginTransaction();//开始事务
               ContentValues contentValues = new ContentValues();
               contentValues.put("name", name);
               contentValues.put("age", age);
               contentValues.put("height", height);
               sqLiteDatabase.insert("home", null, contentValues);
               sqLiteDatabase.setTransactionSuccessful();
           }
       }catch (Exception e) {
           Log.e(homework2.class.toString(),e.toString());
    }finally {
        sqLiteDatabase.endTransaction();//结束事务
        sqLiteDatabase.close();//使用完毕关闭数据库

    }

    }
}
