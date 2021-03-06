package com.example.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Random;

public class DialogShowNote extends DialogFragment {
    TextView txtTitle;
    TextView txtDescription;
    TextView txtToDo;
    TextView txtImportant;
    TextView txtIdea;
    private Note note;
    Random randGenerator = new Random();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        View dialogView = layoutInflater.inflate(R.layout.dialog_show_note, null);

        txtTitle = (TextView) dialogView.findViewById(R.id.txtTitle);
        txtDescription = (TextView) dialogView.findViewById(R.id.txtTitle);
        Button btnOk = (Button) dialogView.findViewById(R.id.btnOk);
        txtToDo = (TextView) dialogView.findViewById(R.id.textViewTodo);
        txtImportant = (TextView) dialogView.findViewById(R.id.textViewImportant);
        txtIdea = (TextView) dialogView.findViewById(R.id.textViewIdea);

        txtTitle.setText(note.getTitle());
        txtDescription.setText(note.getDescription());
        if (!note.isImportant()) {
            txtImportant.setVisibility(View.GONE);
        }
        if (!note.isTodo()) {
            txtToDo.setVisibility(View.GONE);
        }
        if (!note.isIdea()) {
            txtIdea.setVisibility(View.GONE);
        }
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return builder.setView(dialogView).create();
    }

    public void sendNoteSelected(Note note) {
        this.note = note;
    }
}
