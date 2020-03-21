package com.example.course_deatil_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import static com.example.course_deatil_app.MainActivity.reff;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Exam_course.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Exam_course#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Exam_course extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public  TextView v1,v2,v3,v4,v5,v6,v7;


    public Exam_course() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Exam_course.
     */
    // TODO: Rename and change types and number of parameters
    public static Exam_course newInstance(String param1, String param2) {
        Exam_course fragment = new Exam_course();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_exam_course, container, false);
        v1=v.findViewById(R.id.text_view_c1);
        v2=v.findViewById(R.id.text_view_c2);
        v3=v.findViewById(R.id.text_view_c3);
        v4=v.findViewById(R.id.text_view_c4);
        v5=v.findViewById(R.id.text_view_c5);
        v6=v.findViewById(R.id.text_view_c6);
        v7=v.findViewById(R.id.text_view_c7);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("------------------- database_---------------------");
                String credit=dataSnapshot.child("total_credit").getValue().toString();
                System.out.println(credit);
                v1.setText(dataSnapshot.child("total_credit").getValue().toString());
                v2.setText(dataSnapshot.child("IA").getValue().toString());
                v3.setText(dataSnapshot.child("ICE").getValue().toString());
                v4.setText(dataSnapshot.child("ECE").getValue().toString());
                v5.setText(dataSnapshot.child("practical").getValue().toString());
                v6.setText(dataSnapshot.child("project").getValue().toString());
                v7.setText(dataSnapshot.child("total").getValue().toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
//        else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
