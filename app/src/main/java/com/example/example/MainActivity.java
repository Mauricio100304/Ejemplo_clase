package com.example.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private ArrayList<Producto> listaPrincipalProductos;
private RecyclerView rvListadoProductos;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();

        rvListadoProductos = findViewById(R.id.rv_listado_productos);

        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(listaPrincipalProductos);
        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
                @Override
                public void onItemClick(Producto miProducto, int posicion) {
                        Toast.makeText(MainActivity.this, "HICE CLICK DESDE "+ miProducto.getNombre(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemBtnEliminarClick(Producto miProducto, int posicion) {
                        listaPrincipalProductos.remove(posicion);
                        miAdaptador.setListadoInformacion(listaPrincipalProductos);
                }
        });

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));

        }

public void cargarDatos(){
        Producto producto1 = new Producto();
        producto1.setNombre("Computador HP");
        producto1.setPrecio(8000000.0);
        producto1.setUrImagen("https://www.tauretcomputadores.com/images/products/Product_202210181628561688726201.ROG-8.webp");

        Producto producto2 = new Producto("Teclado Dell", 250000.0, "https://www.tauretcomputadores.com/images/products/Product_202212101814141033991635.Origins-60-Aqua-4.webp");
        Producto producto3 = new Producto("Mouse Dell", 200000.0, "https://w7.pngwing.com/pngs/674/140/png-transparent-computer-mouse-gamer-xfire-optical-mouse-dots-per-inch-1000-blue-game-electronics.png");
        //inicializar el arraylist
        listaPrincipalProductos = new ArrayList<>();
        //agregar los productos al arraylist
        listaPrincipalProductos.add(producto1);
        listaPrincipalProductos.add(producto2);
        listaPrincipalProductos.add(producto3);

        }

        }