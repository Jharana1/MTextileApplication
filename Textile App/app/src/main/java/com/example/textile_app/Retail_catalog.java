package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class Retail_catalog extends AppCompatActivity {
    Gallery simpleGallery;

    // CustomizedGalleryAdapter is a java class which extends BaseAdapter
    // and implement the override methods.
    CustomizedGalleryAdapter customGalleryAdapter;
    ImageView selectedImageView;
    TextView name,number;

    // To show the selected language, we need this
    // array of images, here taken 10 different kind of most popular programming languages
    int[] images = {R.drawable.alloverlayout, R.drawable.asymmetricallayout, R.drawable.blockrepeat, R.drawable.borderlayout,
            R.drawable.bricklayout,R.drawable.checklayout, R.drawable.compositelayout, R.drawable.counterchange,
            R.drawable.diamondlayout, R.drawable.diaper,R.drawable.fallon,R.drawable.foulard, R.drawable.fourwaylayout,
            R.drawable.freizepatternlayout, R.drawable.gradationpattern,R.drawable.halfdroprepeatlayout,
            R.drawable.interlockingpattern,R.drawable.nondirectionallayout,R.drawable.onedirectional, R.drawable.packed,
            R.drawable.placementprint,R.drawable.positivenegativelayout,
            R.drawable.stripedlayout,R.drawable.tossedlayout,R.drawable.turnoverlayout,
            R.drawable.twodirectionalpattern
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retail_catalog);
        // Our layout is activity_main
        // get the reference of Gallery. As we are showing languages it is named as languagesGallery
        // meaningful names will be good for easier understanding
        simpleGallery = (Gallery) findViewById(R.id.languagesGallery);

        // get the reference of ImageView
        selectedImageView = (ImageView) findViewById(R.id.imageView);
        name = findViewById(R.id.textView);
        number = findViewById(R.id.textView2);

        // initialize the adapter
        customGalleryAdapter = new CustomizedGalleryAdapter(getApplicationContext(), images);

        // set the adapter for gallery
        simpleGallery.setAdapter(customGalleryAdapter);
        // Let us do item click of gallery and image can be identified by its position
        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Whichever image is clicked, that is set in the  selectedImageView
                // position will indicate the location of image
                selectedImageView.setImageResource(images[position]);
                if(images[position] == R.drawable.alloverlayout){
                    String name1 = "All Over Layout";
                    String number1 = "1";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.asymmetricallayout){
                    String name1 = "Asymmetrical Layout";
                    String number1 = "2";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.blockrepeat){
                    String name1 = "Block Repeat";
                    String number1 = "3";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.borderlayout){
                    String name1 = "Border Layout";
                    String number1 = "4";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.bricklayout){
                    String name1 = "Brick Layout";
                    String number1 = "5";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.checklayout){
                    String name1 = "Check Layout";
                    String number1 = "6";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.compositelayout){
                    String name1 = "Composite Layout";
                    String number1 = "7";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.counterchange){
                    String name1 = "Counter Change";
                    String number1 = "8";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.diamondlayout){
                    String name1 = "Diamond Layout";
                    String number1 = "9";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.diaper){
                    String name1 = "Diaper Layout";
                    String number1 = "10";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.fallon){
                    String name1 = "Fallon";
                    String number1 = "11";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.foulard){
                    String name1 = "Foulard";
                    String number1 = "12";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.fourwaylayout){
                    String name1 = "Four Way Layout";
                    String number1 = "13";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.freizepatternlayout){
                    String name1 = "Freize Pattern Layout";
                    String number1 = "14";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.gradationpattern){
                    String name1 = "Gradation Pattern";
                    String number1 = "15";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.halfdroprepeatlayout){
                    String name1 = "Half Drop Repeat";
                    String number1 = "16";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.interlockingpattern){
                    String name1 = "Interlocking Pattern";
                    String number1 = "17";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.nondirectionallayout){
                    String name1 = "Non Directional Layout";
                    String number1 = "18";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.onedirectional){
                    String name1 = "One Directional Layout";
                    String number1 = "19";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.packed){
                    String name1 = "Packed";
                    String number1 = "20";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.placementprint){
                    String name1 = "Placement Print";
                    String number1 = "21";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.positivenegativelayout){
                    String name1 = "Positive Negative";
                    String number1 = "22";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.stripedlayout){
                    String name1 = "Striped Layout";
                    String number1 = "23";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.tossedlayout){
                    String name1 = "Tossed Layout";
                    String number1 = "24";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.turnoverlayout){
                    String name1 = "Turn Over Layout";
                    String number1 = "25";
                    name.setText(name1);
                    number.setText(number1);
                }
                else if(images[position] == R.drawable.twodirectionalpattern){
                    String name1 = "Two Directional Pattern";
                    String number1 = "26";
                    name.setText(name1);
                    number.setText(number1);
                }
                else{
                    String name1 = "Empty";
                    String number1 = "Empty";
                    name.setText(name1);
                    number.setText(number1);
                }
            }
        });
    }
}
