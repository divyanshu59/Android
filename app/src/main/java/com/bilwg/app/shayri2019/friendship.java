package com.bilwg.app.shayri2019;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

public class friendship extends AppCompatActivity {

    // AdView mAdview;
    private PublisherAdView mPublisherAdView;
    private TextView mValueView;
    private InterstitialAd interstitialAd;
    private ClipboardManager cbm;
    Firebase



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_friendship);



        //Banner ADs
        MobileAds.initialize(this, "ca-app-pub-9733597647251062~7882627863");
        mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);
        //Interstitial Ads
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9733597647251062/6280775734");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                displayInterstitial();
            }
        });

        //Share Button Code
        final TextView mTextView = findViewById(R.id.ShayariView);
        ImageButton mButton = findViewById(R.id.ShareButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mTextView.getText().toString();

                Intent mShareIntent = new Intent(Intent.ACTION_SEND);
                mShareIntent.setType("text/plain");
                mShareIntent.putExtra(Intent.EXTRA_SUBJECT, "This is My Subject");
                mShareIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(mShareIntent, "Share Shayari Via"));
            }
        });

        //Whatsapp Share Button Code
        ImageButton mWhatsappButton = findViewById(R.id.WhatsappShare);

        mWhatsappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mTextView.getText().toString();

                Intent mWhatsShareIntent = new Intent(Intent.ACTION_SEND);
                mWhatsShareIntent.setType("text/plain");
                mWhatsShareIntent.putExtra(Intent.EXTRA_SUBJECT, "This is My Subject");
                mWhatsShareIntent.putExtra(Intent.EXTRA_TEXT, text);
                mWhatsShareIntent.setPackage("com.whatsapp");
                startActivity(mWhatsShareIntent);
            }
        });

        ImageButton mCopyButton = findViewById(R.id.CopyButton);


        mCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView mTextView = findViewById(R.id.ShayariView);
                String textas = mTextView.getText().toString();
                ClipboardManager myClipboard;
                myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData myClip;

                myClip = ClipData.newPlainText("text", textas);
                myClipboard.setPrimaryClip(myClip);
            }
        });

    }


    public void displayInterstitial() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }

    private FirebaseDatabase mRef;
    @Override
    protected void onStart() {
        super.onStart();

    }
}
