package com.example.bmi_app.calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bmi_app.R
import com.example.bmi_app.databinding.FragmentCalculatorBinding

class CalculatorFragment: Fragment(), SeekBar.OnSeekBarChangeListener {

    lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculator, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        binding.viewModel = viewModel

        registerObservers()
        setEventListeners()

        return binding.root
    }

    private fun registerObservers(){
        // Navigate to ResultFragment
        viewModel.navigateToResultFragment.observe(viewLifecycleOwner, Observer {
            it?.let{
                bmi ->
                    val action = CalculatorFragmentDirections.actionCalculatorFragment3ToResultFragment(bmi)
                    this.findNavController()?.navigate(action)
                    viewModel.navigationDone()
            }
        })
    }

    private fun setEventListeners(){
        binding.heightSeekbar.setOnSeekBarChangeListener(this)
        binding.weightSeekbar.setOnSeekBarChangeListener(this)
    }

    // ################################################################################################################
    // Extension: SeekBar Delegate Methods
    // ################################################################################################################
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekBar?.let{
            return when(it.id){
                binding.heightSeekbar.id -> viewModel.onHeightChangedHandler(it.progress)
                binding.weightSeekbar.id -> viewModel.onWeightChangedHandler(it.progress)
                else -> Unit
            }
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        return
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        return
    }
    // #################################################################################################################
}