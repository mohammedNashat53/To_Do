package com.example.tujweed.ui.ahkam.learning_tujweed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.tujweed.R
import com.example.tujweed.utility.Videos
import com.example.tujweed.adapters.VideosAdapter
import com.example.tujweed.databinding.FragmentLearnTujweedBinding


class LearningTujweedFragment : Fragment() {

    lateinit var videoView: VideoView
lateinit var binding: FragmentLearnTujweedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentLearnTujweedBinding.inflate(inflater,container,false)
        val adapter = VideosAdapter(list())
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    private fun list(): List<Videos>{
        return listOf<Videos>(
//            Videos("مقدمة في علم التجويد",R.raw),
//            Videos("مقدمة في علم التجويد 2",R.raw),
//            Videos("باب مخارج الحروف ( الحلق )",R.raw),
//            Videos("باب مخارج الحرف الجوف",R.raw),
//            Videos("باب مخارج الحروف اللسان",R.raw),
//            Videos("باب مخارج الحروف اللسان 2",R.raw),
//            Videos("باب صفات الحروف الصفات المتضادة",R.raw),
//            Videos("باب صفات الحروف الشدة والرخاوة",R.raw),
//            Videos("قياس أزمنة الحروف",R.raw),
//            Videos("باب صفات الحروف الإستعلاء والإستفال",R.raw),
//            Videos("باب صفات الحروف حكم الألف واللام والراء",R.raw),
//            Videos("باب صفات الحروف الإطباق والأنفتاح",R.raw),
//            Videos("باب صفات الحروف القلقلة",R.raw),
//            Videos("نصائح لإهل القرآن",R.raw),
//            Videos("باب صفات الحروف اللين",R.raw),
//            Videos("باب صفات الحروف الغنة",R.raw),
//            Videos("أخطاء عند نطق حروف الهجاء",R.raw),
//            Videos("إتمام الحركات",R.raw),
//            Videos("باب الوقف والإبتداء",R.raw),
//            Videos("مقدمة القسم الثاني من الدورة",R.raw),
//            Videos("الحرفان الملتقيان",R.raw),
//            Videos("الحرفان الملتقيان 2",R.raw),
//            Videos("الميم الساكنة",R.raw),
//            Videos("النون الساكنة والتنوين",R.raw),
//            Videos("النون الساكنة الإخفاء",R.raw),
//            Videos("المدود",R.raw),
//            Videos("قياس أزمنة المدود",R.raw),
//            Videos("المد الطبيعى ",R.raw),
//            Videos("المد الجائز المنفصل",R.raw),
//            Videos("الحروف المتقطعة فى القرآن الكريم",R.raw),
//            Videos("الحروف المتقطعة فى القرآن الكريم 2",R.raw),
//            Videos("المد العارض للسكون",R.raw),
//            Videos("قاعدة أقوى السببين",R.raw),
//            Videos("إلتقاء الحرفين الساكنين",R.raw),
//            Videos("الإمالة والنبر",R.raw),
//            Videos("الروم والإشمام",R.raw),
//            Videos("ما لا يدخله الرو والإشمام",R.raw),
//            Videos("الألفات السبعة",R.raw),
//            Videos("همزة القطع",R.raw),
//            Videos("مراحل تطور وكتابة المصحف الشريف",R.raw),
//            Videos("مراحل تطور وكتابة المصحف الشريف 2",R.raw),
//            Videos("كلمات قرآنية لها وضع خاص عند حفص",R.raw),
//            Videos("مراحل تطور وكتابة المصحف الشريف",R.raw),
//            Videos("مراحل تطور وكتابة المصحف الشريف 3",R.raw),
//            Videos("حفظ القرآن الكريم",R.raw),
        )
    }

}

