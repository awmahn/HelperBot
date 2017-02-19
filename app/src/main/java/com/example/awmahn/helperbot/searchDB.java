package com.example.awmahn.helperbot;

import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class searchDB extends AppCompatActivity {

    private int _id;
    private String _name;
    private String _url;
    public searchDB() {}

    public void searchDB(String name) { this._name = name; }
    public int get_id() { return _id; }
    public void set_id(int _id) { this._id = _id; }
    public String get_name() { return _name; }
    public void set_name(String _name) { this._name = _name;}
    public String get_url() {
        return _url;
    }
    public void set_url(String url) {
        _url = url;
    }
}
