package com.example.guardarinfocontactos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AgregarContacto extends Activity {

	private InterlocutorContactos ic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agregar_contacto);
		
		ic = new InterlocutorContactos(this);

	}
	
	public void eventoGuardar(View vista) {
		String nombreAP=((EditText) this.findViewById(R.id.nombreAp)).getText().toString();
		String telefono=((EditText) this.findViewById(R.id.telefono)).getText().toString();
		String email=((EditText) this.findViewById(R.id.email)).getText().toString();
		String direccion=((EditText) this.findViewById(R.id.direccion)).getText().toString();
		
		if (nombreAP!=null) {
			ic.guardarContacto(nombreAP,telefono,email,direccion);
		} else {
			((TextView) this.findViewById(R.id.tvMensaje)).setText("Rellena al menos el nombre");
		}
				
	}
	
}
