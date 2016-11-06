package com.example.androidtext23_contentobserver;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private ContentResolver resolver;
    public TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resolver = getContentResolver();
        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI,
                true, new ContactsObserver(new Handler()));
        txt = (TextView) findViewById(R.id.txt);
        Button btn_getAllContact = (Button) findViewById(R.id.button);
        btn_getAllContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                String msg = "";
                if (cursor == null) return;
                while (cursor.moveToNext()) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    msg += "id:" + id + " name:" + name;
                    Cursor phoneNumbers=resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +"="+id,null,null);
                    while(phoneNumbers.moveToNext()){
                        String phoneNumber=phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        msg+="phoneNumber:"+phoneNumber+ "\n";
                    }
                }
                cursor.close();
                txt.setText(msg);
            }
        });
    }
    private final class ContactsObserver extends ContentObserver {
        public ContactsObserver(Handler handler)
        {
            super(handler);
        }
        @Override
        public void onChange(boolean selfChange) {
            Log.v("BXY tag", "Contact data is changed.");
            Toast.makeText(MainActivity.this, "add phoneNum success", Toast.LENGTH_SHORT).show();
        }
    }
}


