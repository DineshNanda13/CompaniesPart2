package com.meterstoinches.companiespart2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    DatabaseHandler mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 =(TextView)findViewById(R.id.t);
        t1.setText("");
        t1.setMovementMethod(new ScrollingMovementMethod());
        mydb=new DatabaseHandler(this);
        mydb.getReadableDatabase();

        displayall();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.adding){
            addonecompany();
            update();
            return true;
        }
        if (id==R.id.addingMany){
            addmany();
            update();
            return true;
        }
        if(id==R.id.deleteLastRow){
            mydb.deleteLastRow();
            update();
            return true;
        }
        if(id==R.id.deletingall){
            mydb.deleteAll();
            update();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void addonecompany(){
        mydb.addCompany("happy","0090","park","h2b2h2","b01","abc@gmail.com","tammy","vivek","textile");
    }
    public void addmany() {
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");
        mydb.addCompany("sam", "838", "lasalle", "h1n1v1", "c21", "sam@gmail.com", "sammy", "dinesh", "videotron");

    }
    public void displayall(){
        List<Companies> companies =mydb.getallCompanies();
        if(companies.size()==0){
            t1.setText("No records in the Database");
        }

        for (Companies c:companies){
            String log="Companyref: "+c.getComapnyRef()+" ,Formalname: "+c.getFormalName()
                    +" , Companytypecode: "+c.getCompanyTypeCode()+" ,Mainaddress: "+c.getMainAdress()
                    +" ,Mainpostcode: "+c.getMainPostcode()+" , Receptionno: "+c.getReceptionNo()
                    +" , websiteurl: "+c.getWebsiteURL()+" , Customer: "+c.getCustomer()+
                    " , Supplier: "+c.getSupplier()+" ,Companynotes: "+c.getCompaynotes();
            t1.append(log+"\n");
        }

    }
    public void update(){
        t1.setText("");
        displayall();
    }
}
