package com.jasim0021.recyleview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;

    ArrayList<ContactModel> arrayContact;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrayContact){
        this.context=context;
        this.arrayContact=arrayContact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v =  LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);

      ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgContact.setImageResource(arrayContact.get(position).img);
        holder.txtName.setText(arrayContact.get(position).name);
        holder.txtNumber.setText(arrayContact.get(position).number);
        holder.contactRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);
                EditText editName,editNumber;
                TextView tvHeading;
                Button btn;

                editName = dialog.findViewById(R.id.name_add_contact);
                editNumber = dialog.findViewById(R.id.number_add_contact);
                tvHeading = dialog.findViewById(R.id.headingTitle);
                btn = dialog.findViewById(R.id.btn_add_contact);
                btn.setText("Update");
                tvHeading.setText("Update Contact");

                editName.setText(arrayContact.get(position).name);
                editNumber.setText(arrayContact.get(position).number);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";
                        if(!editName.getText().toString().equals("") && !editNumber.getText().toString().equals("")) {
                            name = editName.getText().toString();
                            number = editNumber.getText().toString();

                            arrayContact.set(position,new ContactModel(arrayContact.get(position).img, name,number));
                            notifyItemChanged(position);
                            Toast.makeText(context, "Update Successfull", Toast.LENGTH_SHORT).show();
                            dialog.cancel();


                        }else {
                            Toast.makeText(context, "Please Enter a Valid Input", Toast.LENGTH_SHORT).show();

                        }

                    }
                });


                dialog.show();
            }

        });

        holder.contactRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder =  new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                arrayContact.remove(position);
                               notifyItemRemoved(position);
//                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.dismiss();
                            }
                        });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName,txtNumber;
        ImageView imgContact;

        CardView contactRow;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

           imgContact= itemView.findViewById(R.id.contactImage);
           txtName= itemView.findViewById(R.id.contactName);
           txtNumber= itemView.findViewById(R.id.contactNumber);
           contactRow= itemView.findViewById(R.id.contactRow);
        }
    }

}
