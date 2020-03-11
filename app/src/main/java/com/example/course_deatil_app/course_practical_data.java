package com.example.course_deatil_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import com.example.course_deatil_app.practical_two_view_cont;
import com.example.course_deatil_app.ui.main.practical_adapter;

import static com.example.course_deatil_app.MainActivity.Practical_content;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link course_practical_data.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link course_practical_data#newInstance} factory method to
 * create an instance of this fragment.
 */
public class course_practical_data extends Fragment {
    List<practical_two_view_cont> final_practical_data_list;
    private practical_adapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public course_practical_data() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment course_practical_data.
     */
    // TODO: Rename and change types and number of parameters
    public static course_practical_data newInstance(String param1, String param2) {
        course_practical_data fragment = new course_practical_data();
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
        View view=inflater.inflate(R.layout.fragment_course_practical_data, container, false);
        //String[] contentf = getResources().getStringArray(R.array.coursepractical);
        //String[] contentf = getResources().getStringArray(getResources().getIdentifier("coursepractical","array",getContext().getPackageName()));

        //String[] contentf={"Unit 1","Unit 2","Unit 3"};
          List<String> practical_course_title_list  = new ArrayList<>();
          List<String> practical_course_content_list = new ArrayList<>();
          final_practical_data_list=new ArrayList<>();
          for (int i=0;i<Practical_content.length;i++){
            if (i%2==0){
                practical_course_title_list.add(Practical_content[i]);
            }
            else {
                practical_course_content_list.add(Practical_content[i]);
            }
        }
        ListView listView = view.findViewById(R.id.course_practical_list);
        final_practical_data_list.add(new practical_two_view_cont(practical_course_title_list.get(0),practical_course_content_list.get(0)));
        final_practical_data_list.add(new practical_two_view_cont(practical_course_title_list.get(1),practical_course_content_list.get(1)));
        final_practical_data_list.add(new practical_two_view_cont(practical_course_title_list.get(2),practical_course_content_list.get(2)));

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,contentf);
        //listView.setAdapter(adapter);
        adapter=new practical_adapter(getContext(),final_practical_data_list);
        listView.setAdapter(adapter);
        return view;
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
