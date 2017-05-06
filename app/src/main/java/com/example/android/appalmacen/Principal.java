package com.example.android.appalmacen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private Spinner cmbSexo, cmbCalzado, cmbMarca;
    private TextView txtUnitario, txtCantidad, txtTotalCompra;
    private String[] opcionesSexo;
    private String[] opcionesCalzado;
    private String[] opcionesMarca;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        txtTotalCompra = (TextView) findViewById(R.id.txtTotalCompra);
        txtUnitario = (TextView) findViewById(R.id.txtUnitario);

        cmbSexo = (Spinner)findViewById(R.id.cmbSexo);
        cmbCalzado = (Spinner)findViewById(R.id.cmbCalzado);
        cmbMarca = (Spinner)findViewById(R.id.cmbMarca);

        // llenado de cmbsexo
        opcionesSexo = this.getResources().getStringArray(R.array.opcionesSexo);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opcionesSexo);
        cmbSexo.setAdapter(adapter);

        // llenado de cmbCalzado
        opcionesCalzado = this.getResources().getStringArray(R.array.opcionesCalzado);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opcionesCalzado);
        cmbCalzado.setAdapter(adapter);

        // llenado de cmbmarca
        opcionesMarca = this.getResources().getStringArray(R.array.opcionesMarca);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opcionesMarca);
        cmbMarca.setAdapter(adapter);


    }

    public void calcular(View v){
        int opSexo, opCalzado, opMarca;
        double cantidad, res=0;
        if(validar()) {

            cantidad = Double.parseDouble(txtCantidad.getText().toString());

            opSexo = cmbSexo.getSelectedItemPosition();
            opCalzado = cmbCalzado.getSelectedItemPosition();
            opMarca = cmbMarca.getSelectedItemPosition();

            switch (opSexo){
                case 0:
                    switch (opCalzado){
                        case 0:
                            switch (opMarca) {
                                case 0:
                                    res = 120000 * cantidad;
                                    break;
                                case 1:
                                    res = 140000 * cantidad;
                                    break;
                                case 2:
                                    res = 130000 * cantidad;

                            }
                            break;
                        case 1:
                            switch (opMarca) {
                                case 0:
                                    res = 50000 * cantidad;
                                    break;
                                case 1:
                                    res = 80000 * cantidad;
                                    break;
                                case 2:
                                    res = 100000 * cantidad;

                            }
                            break;
                    }
                    break;
                case 1:
                    switch (opCalzado){
                        case 0:
                            switch (opMarca) {
                                case 0:
                                    res = 100000 * cantidad;
                                    break;
                                case 1:
                                    res = 130000 * cantidad;
                                    break;
                                case 2:
                                    res = 110000 * cantidad;

                            }
                            break;

                        case 1:
                            switch (opMarca) {
                                case 0:
                                    res = 60000 * cantidad;
                                    break;
                                case 1:
                                    res = 70000 * cantidad;
                                    break;
                                case 2:
                                    res = 120000 * cantidad;

                            }
                            break;
                    }
                    break;
            }


            txtTotalCompra.setText(" " + res);

            txtUnitario.setText(" "+ res/cantidad);
        }
    }

    public boolean validar(){
        if(txtCantidad.getText().toString().isEmpty()){
            txtCantidad.requestFocus();
            txtCantidad.setError(this.getResources().getString(R.string.error_campo));
            return false;
        }

        return true;
    }

    public void borrar(View v){
        txtCantidad.setText("");
    }


}
