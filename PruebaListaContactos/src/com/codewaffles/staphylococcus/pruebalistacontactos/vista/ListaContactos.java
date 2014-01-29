package com.codewaffles.staphylococcus.pruebalistacontactos.vista;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.codewaffles.staphylococcus.pruebalistacontactos.R;
import com.codewaffles.staphylococcus.pruebalistacontactos.datos.CargadorContactos;

public class ListaContactos extends Activity {
	
	private static final int CARGADOR_ID = 1;

	private String from[] = {
			ContactsContract.Contacts._ID,
			ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
			
	};
	
	private int to[] = {
			R.id.elemId,
			R.id.elemNombre//,
			//R.id.elemTlf
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_contactos);
		
		ListView listadoContactos = (ListView) this.findViewById(R.id.listadoContactos);
		SimpleCursorAdapter adaptador=new SimpleCursorAdapter(this, R.layout.elemento_lista, null, from, to, 0);
		listadoContactos.setAdapter(adaptador);
		
		this.getLoaderManager().initLoader(CARGADOR_ID, null, new CargadorContactos(adaptador, CARGADOR_ID, this));
	}

}
