package gaba.vinay.to;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String KEY_NAME = "name";
        final String KEY_PH_NO = "phone_number";
       DatabaseHandler db = new DatabaseHandler(this);
       ImageButton addactivity = (ImageButton) findViewById(R.id.btnAddSite);
       ListView listview=(ListView) findViewById(android.R.id.list);
   
      
       ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
       List<Contact> contacts=db.getAllContacts();
	         for(int i = 1; i < contacts.size()+1; i++){
	        	 Contact person1=db.getContact(i);
	        	 String name=person1.getName();
	        	 String phone = person1.getPhoneNumber();
	        	 
	        	 HashMap<String,String> map = new HashMap<String,String>();
	         	//map.put(KEY_PH_NO,phone);
	         	map.put(KEY_NAME, name);
	         	map.put(KEY_PH_NO,phone);
	         	contactList.add(map);
}
	         ListAdapter adapter = new SimpleAdapter(this, contactList,
	                 R.layout.list_item,
	                 new String[] {KEY_PH_NO,KEY_NAME}, new int[] {
	                         R.id.phone,R.id.name});
	  
	         setListAdapter(adapter);
	         registerForContextMenu(listview);
	         /*this.getListView().setLongClickable(true);
	         this.getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
	              public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
	              //Do some
	            	  Toast.makeText(MainActivity.this, "postion: " +    getListView().getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
	                  return true;
	              }
	          });
*/

	         
	         addactivity.setOnClickListener(new View.OnClickListener() {
	 			
	 			@Override
				public void onClick(View v) {
	 				Intent i = new Intent(getApplicationContext(), Add.class);
	 				// starting new activity and expecting some response back
	 				// depending on the result will decide whether new website is
	 				// added to SQLite database or not
	                 startActivityForResult(i, 100);
	 			}
	 		});
	}
/*
	@Override
    public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenuInfo menuInfo) {
     if (v.isClickable()) {
        menu.setHeaderTitle("Delete");
        	menu.add(Menu.NONE, 0, 0, "Delete Activity");
        	int sel=v.getId();
      }
    }
    
    /**
     * Responding to context menu selected option
     * */
    
   /* public boolean onContextItemSelected(MenuItem item) {
      AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
     int arrayAdapterPosition = (int) info.id;
    	
      int menuItemIndex = item.getItemId();
      // check for selected option
      if(menuItemIndex == 0){
    	  // user selected delete
    	  // delete the feed
    	 // RSSDatabaseHandler rssDb = new RSSDatabaseHandler(getApplicationContext());
    	  //WebSite site = new WebSite();
    	  //site.setId(Integer.parseInt(sqliteIds[info.position]));
    	  //rssDb.deleteSite(site);
    	  //reloading same activity again
    	  DatabaseHandler db = new DatabaseHandler(this);
    	  
    	  Contact person=new Contact();
    	  person.setId(Integer.parseInt(sqliteIds[info.position]));
    	  int id= person.getID();
    	  db.deleteContact(person);
    	  Intent intent = getIntent();
          finish();
          startActivity(intent);
      }
      
      return true;
    }
	
*/
}
