package com.codewaffles.staphylococcus.pruebalistacontactos.datos;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;


public class CargadorContactos implements LoaderCallbacks<Cursor> {
	
	private SimpleCursorAdapter adaptador;
	private static int CARGADOR_ID;
	private Context contexto;

	public CargadorContactos(SimpleCursorAdapter adaptador,int id, Context contexto) {
		this.adaptador=adaptador;
		CARGADOR_ID=id;
		this.contexto=contexto;
	}

	@Override
	public Loader<Cursor> onCreateLoader(int idLoader, Bundle estado) {
		if (idLoader==CARGADOR_ID) {
			return new CursorLoader(contexto, 
									ContactsContract.Contacts.CONTENT_URI,
									new String[] {ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME_PRIMARY},
									null, null, null);	
		}
		else return null;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		if (loader.getId()==CARGADOR_ID) {
			adaptador.swapCursor(cursor);
		}
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		if (loader.getId()==CARGADOR_ID) {
			adaptador.swapCursor(null);
		}
	}

}
