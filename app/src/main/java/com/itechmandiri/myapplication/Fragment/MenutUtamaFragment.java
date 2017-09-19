package com.itechmandiri.myapplication.Fragment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.itechmandiri.myapplication.Activity.Alerts;
import com.itechmandiri.myapplication.Activity.Analytics;
import com.itechmandiri.myapplication.Activity.AroundMe;
import com.itechmandiri.myapplication.Activity.Contacts;
import com.itechmandiri.myapplication.Activity.Customers;
import com.itechmandiri.myapplication.Activity.Forecast;
import com.itechmandiri.myapplication.Activity.Leads;
import com.itechmandiri.myapplication.Activity.Opportunities;
import com.itechmandiri.myapplication.Activity.TaskOL;
import com.itechmandiri.myapplication.Activity.MenuCalendar;
import com.itechmandiri.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenutUtamaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenutUtamaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenutUtamaFragment extends Fragment {

    ActionBar actionBar;

    private ViewFlipper viewFlipper;
    ImageView next;
    ImageView previous;

    private ImageButton btnCalender, btnAlerts, btnOpportunities, btnTasks, btnContacts, btnAroundMe, btnCustomers,
            btnAnalytics, btnLeads, btnForecast;

    Intent FungsiCalender,FungsiAlerts,FungsiOpportunities,FungsiTasks,FungsiContacts,FungsiAroundMe,FungsiCustomers,
            FungsiAnalytics,FungsiLeads,FungsiForecast,FungsiAbout,FungsiSetting,FungsiExit;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MenutUtamaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenutUtamaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenutUtamaFragment newInstance(String param1, String param2) {
        MenutUtamaFragment fragment = new MenutUtamaFragment();
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
        return inflater.inflate(R.layout.fragment_menut_utama, container, false);

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
        } else {
         return;
        }
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCalender = (ImageButton) view.findViewById(R.id.btnMenu01);
        btnAlerts = (ImageButton) view.findViewById(R.id.btnMenu02);
        btnOpportunities = (ImageButton) view.findViewById(R.id.btnMenu03);
        btnTasks = (ImageButton) view.findViewById(R.id.btnMenu04);
        btnContacts = (ImageButton) view.findViewById(R.id.btnMenu05);
        btnAroundMe = (ImageButton) view.findViewById(R.id.btnMenu06);
        btnCustomers = (ImageButton) view.findViewById(R.id.btnMenu07);
        btnAnalytics = (ImageButton) view.findViewById(R.id.btnMenu08);
        btnLeads = (ImageButton) view.findViewById(R.id.btnMenu09);
        btnForecast = (ImageButton) view.findViewById(R.id.btnMenu10);

        btnCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuCalendar.class);
                getActivity().startActivity(intent);
            }
        });
        btnAlerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Alerts.class);
                getActivity().startActivity(intent);
            }
        });
        btnOpportunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Opportunities.class);
                getActivity().startActivity(intent);
            }
        });
        btnTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TaskOL.class);
                getActivity().startActivity(intent);
            }
        });
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Contacts.class);
                getActivity().startActivity(intent);
            }
        });
        btnAroundMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AroundMe.class);
                getActivity().startActivity(intent);
            }
        });
        btnCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Customers.class);
                getActivity().startActivity(intent);
            }
        });
        btnAnalytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Analytics.class);
                getActivity().startActivity(intent);
            }
        });

        btnLeads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Leads.class);
                getActivity().startActivity(intent);
            }
        });

        btnForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Forecast.class);
                getActivity().startActivity(intent);
            }
        });


    }

}
