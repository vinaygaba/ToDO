package gaba.vinay.to;







import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Add extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		 final DatabaseHandler db= new DatabaseHandler(this);
		 final String KEY_NAME = "name";
	         final String KEY_PH_NO = "phone_number";
		Button save = (Button) findViewById(R.id.save);
		final EditText activity = (EditText) findViewById(R.id.activity);
		
		 save.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					String act=activity.getText().toString();
					db.addContact(new Contact(act, ""));
					Intent i = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(i);
				}
			});
	}

}
