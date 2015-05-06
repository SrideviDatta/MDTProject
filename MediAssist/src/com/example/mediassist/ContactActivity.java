//Source: http://www.javaexperience.com/listview-section-based-fast-scroll-in-android/

package com.example.mediassist;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
 
public class ContactActivity extends Activity implements OnItemClickListener{
    ListView listView;
    public static int i;
    public static String[] phoneNos={"123-456-7891","999-999-9999","654-123-1241","234-456-7890","111-111-1111","222-222-2222"}; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
       final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        listView = (ListView) findViewById(R.id.sportsList);
        listView.setOnItemClickListener(this);
        
        final Button broadcast=(Button) findViewById(R.id.submit);
        broadcast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click  '
            	alertDialogBuilder.setTitle("Message Broadcasted!");
    			alertDialogBuilder
    			.setMessage("Message has been sent to contacts");
    			alertDialogBuilder.show();

            }
        });
        
        final Button back=(Button) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click  '
            	Intent intent = new Intent(ContactActivity.this, MainActivity.class);
        		
        		
        	    startActivity(intent);

            }
        });
    }
 
    /*
     * Parameters:
        adapter - The AdapterView where the click happened.
        view - The view within the AdapterView that was clicked
        position - The position of the view in the adapter.
        id - The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    	
    	System.out.println("in on item click"+i);
			// set title
			alertDialogBuilder.setTitle(((TextView) view).getText());
			alertDialogBuilder
			.setMessage(phoneNos[i]).setNegativeButton("Send SMS",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});
			
			alertDialogBuilder.show();
			i++;
      
    }
    public void onClickListener()
    {
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    	alertDialogBuilder
		.setMessage("Message Broadcasted");
    }
}