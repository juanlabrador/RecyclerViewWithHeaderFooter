package com.juanlabrador.recyclerviewwithheaderfooter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class DailyMenuActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private DailyMenuAdapter mAdapter;
    private ArrayList<Item> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_menu);

        initData();

        init();
    }

    private void init() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mAdapter = new DailyMenuAdapter(this, mItems);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData() {
        mItems = new ArrayList<>();

        mItems.add(new Item("Hoy"));
        mItems.add(new Item(
                "Ya cuadre una rica cena con mi novia, ¿será un momento de comida japonesa? Espero le de antojos :)",
                R.mipmap.deliver_food,
                R.drawable.bento,
                "7:30 pm"));
        mItems.add(new Item(
                "Me toca cocina en casa, quizás una rica sopa de res.",
                R.mipmap.cooker,
                R.drawable.cooking_pot,
                "12:30 pm"));
        mItems.add(new Item(
                "Despertando para un rico café.",
                R.mipmap.cafe,
                "7:00 AM"));
        mItems.add(new Item());
        mItems.add(new Item("Ayer"));
        mItems.add(new Item(
                "Celebrando el cumpleaños de mi hermano, ya son 30 años.",
                R.mipmap.beer_bottle,
                R.drawable.birthday_cake,
                "8:00 pm"
        ));
        mItems.add(new Item(
                "En el trabajo, a veces tomo una merienda en las tardes, hoy toco un \"Cupcake\".",
                R.mipmap.cupcake,
                "4:30 pm"
        ));
        mItems.add(new Item(
                "Invite a almorzar a mi novia, por cumplir otro mes juntos.",
                R.mipmap.waiter,
                R.drawable.spaghetti,
                "12:15 pm"
        ));
        mItems.add(new Item(
                "Me desperte muy tarde hoy... muy tarde. Sale algo rápido.",
                R.mipmap.bread,
                "8:30 am"
        ));
        mItems.add(new Item());
        mItems.add(new Item("Domingo 16-Agosto-2015"));
        mItems.add(new Item(
                "Me encanta cenar en la calle. Cena con mi pareja.",
                R.mipmap.restaurant_pickup,
                R.drawable.noodles,
                "7:20 pm"
        ));
        mItems.add(new Item(
                "Parrilla con los amigos.",
                R.mipmap.sun,
                R.drawable.kebab,
                "3:00 pm"
        ));
        mItems.add(new Item());
        mItems.add(new Item("Sabado 15-Agosto-2015"));
        mItems.add(new Item(
                "Bar con los amigos, tomando unas cervezas.",
                R.mipmap.beer,
                "8:40 pm"
        ));
        mItems.add(new Item(
                "Adoro ir a McDonalds\'s.",
                R.mipmap.french_fries,
                R.drawable.hamburger,
                "7:15 pm"
        ));
        mItems.add(new Item(
                "Almuerzo con unos amigos.",
                R.mipmap.vegetarian_food,
                R.drawable.wrap,
                "12:40 pm"
        ));
        mItems.add(new Item());


    }
}
