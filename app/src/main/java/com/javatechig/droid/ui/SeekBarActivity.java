package com.javatechig.droid.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends Activity {

    private AlertDialog alerta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_slider);

        ImageView imgLeftSlider = (ImageView) findViewById(R.id.imageview_left_slider);
        ImageView imgMiddleSlider = (ImageView) findViewById(R.id.imageview_middle_slider);
        ImageView imgRigthSlider = (ImageView) findViewById(R.id.imageview_rigth_slider);

        TextView textViewLeftSlider = (TextView) findViewById(R.id.textview_left_slider);
        TextView textViewMiddleSlider = (TextView) findViewById(R.id.textview_middle_slider);
        TextView textViewRigthSlider = (TextView) findViewById(R.id.textview_rigth_slider);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar_slider);

        final SeekBar seekBarSlider = setSeekBarSlider(seekBar, getResources().getDrawable(R.drawable.circle), 100, 20);

        setImageViewSlider(imgLeftSlider, imgMiddleSlider, imgRigthSlider, getResources().getDrawable(R.drawable.slider_block), getResources().getDrawable(R.drawable.slider_check), getResources().getDrawable(R.drawable.slider_block));

        setTextViewSlider(textViewLeftSlider, textViewMiddleSlider, textViewRigthSlider, "CONSULTAR", "HABILITAR", "EXCLUIR");

        seekBarSlider.postInvalidate();

        seekBarSlider.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            int progressChange = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChange = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(progressChange >= 0 && progressChange <=25){

                    exemplo_simples();

                    seekBarSlider.setProgress(0);

                } else if(progressChange > 25 && progressChange < 50){
                    seekBarSlider.setProgress(50);
                    exemplo_simples();
                } else if(progressChange > 50 && progressChange < 75){
                    seekBarSlider.setProgress(50);
                    exemplo_simples();
                } else if(progressChange >= 75 && progressChange <= 100){
                    seekBarSlider.setProgress(100);
                    exemplo_simples();
                }

                if(progressChange == 0){
                    seekBarSlider.setOnClickListener(null);
                }



            }
        });


    }

    private void exemplo_simples() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Titulo");
        //define a mensagem
        builder.setMessage("Qualifique este software");
        //define um botão como positivo
        builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(SeekBarActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(SeekBarActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    public void setImageViewSlider(ImageView imageViewLeft, ImageView imageViewMiddle, ImageView imageViewRigth, Drawable drawableLeftSlider, Drawable drawableMiddleSlider, Drawable drawableRifthSlider){
        imageViewLeft.setImageDrawable(drawableLeftSlider);
        imageViewMiddle.setImageDrawable(drawableMiddleSlider);
        imageViewRigth.setImageDrawable(drawableRifthSlider);
    }

    public void setTextViewSlider(TextView textViewLeft, TextView textViewMiddle, TextView textViewRigth, String stringLeft, String stringMiddle, String stringRigth){
        textViewLeft.setText(stringLeft);
        textViewMiddle.setText(stringMiddle);
        textViewRigth.setText(stringRigth);
    }

    public  SeekBar setSeekBarSlider(SeekBar seekBarSlider, Drawable thumb, int maxPosition, int thumbOfSet){

        seekBarSlider.setThumb(thumb);
        seekBarSlider.setThumbOffset(thumbOfSet);

        seekBarSlider.setMax(maxPosition);

        return seekBarSlider;


    }

    private  class SliderListener implements  OnSeekBarChangeListener  {
        private  int smoothnessFactor =  1;
        public  void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser)  {
            progress =  Math.round(progress/smoothnessFactor );
//            TextView lblProgress =  ( TextView ) findViewById ( R . id . lblProgress );
//            lblProgress . setText ( String . valueOf ( progress ));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        public  void onStopTrackingTouch(SeekBar seekBar) {
            seekBar.setProgress(Math.round((seekBar.getProgress() + (smoothnessFactor/2)) / smoothnessFactor) * smoothnessFactor);
        }
    }

}
