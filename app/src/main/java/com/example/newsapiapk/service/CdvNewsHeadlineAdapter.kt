class CdvNewsHeadlineAdapter : RecyclerView.Adapter<CdvNewsHeadlineVH>() {

    //untuk mengambil data di dalam model article item
    private val listData = ArrayList<ArticlesItem>()

    //fungsi ini berfungsi untuk add data ke dalam recyclerview
    fun addData(items: List<ArticlesItem>) {
        listData.clear()
        listData.addAll(items)
        notifyDataSetChanged()
    }

    //berfungsi untuk menginflate atau menerapkan operasi yang di buat kedalam layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvNewsHeadlineVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CdvNewsHeadlineBinding.inflate(layoutInflater, parent, false)
        return CdvNewsHeadlineVH(binding)
    }

    //digunakan untuk mengetahui panjang/banyak data(size) guna kebutuhan looping
    override fun getItemCount(): Int {
        return listData.size
    }

    //digunakan untuk memposisikan widget pada layout model
    override fun onBindViewHolder(holder: CdvNewsHeadlineVH, position: Int) {

    }
}

//sebagai adapter recyclerview
class CdvNewsHeadlineVH(private val binding: CdvNewsHeadlineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: ArticlesItem) {
        binding.run {
            txtTitle.text = cropText(article.title?: "Tidak ada judul")
            txtSubtitle.text = article.publishedAt
            imgHeadline.apply {
                load(article.urlToImage){
                    scale(Scale.FILL)
                }
            }
        }
    }

    //untuk memotong text yang lebih dari 50
    private fun cropText(text: String): String {
        return text.take(50) + if (text.length > 50)"..." else ""
    }
}
