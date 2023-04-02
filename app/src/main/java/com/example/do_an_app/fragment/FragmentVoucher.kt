package com.example.do_an_app.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.do_an_app.adapter.PagerAdapter
import com.example.do_an_app.databinding.FragmentVoucherBinding
import com.google.android.material.tabs.TabLayoutMediator

class FragmentVoucher: Fragment() {
    private lateinit var binding: FragmentVoucherBinding
    var tab_title = listOf("Chờ xác nhận", "Đã xác nhận", "Đã hết hạn", "Đã trả", "Đã hủy")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVoucherBinding.inflate(inflater, container, false)
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
        val pager = binding.pager
        val tab_fragment = binding.tabLayout

        pager.adapter = PagerAdapter(requireActivity().supportFragmentManager, lifecycle)

        TabLayoutMediator(tab_fragment, pager) {
            tab, position ->
                    tab.text = tab_title[position]
//            pager.adapter?.let {
//                (it as PagerAdapter).refreshFragment(position)
//            }
        }.attach()

//        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                val adapter = pager.adapter as? PagerAdapter
//                adapter?.refreshFragment(position)
//            }
//        })


        return binding.root
    }

}