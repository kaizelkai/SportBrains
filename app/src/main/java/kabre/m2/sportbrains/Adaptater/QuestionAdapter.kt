package kabre.m2.sportbrains.Adaptater

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kabre.m2.sportbrains.QuestionMainActivity
import kabre.m2.sportbrains.R
import kabre.m2.sportbrains.VictoryMainActivity
import kabre.m2.sportbrains.databinding.ViewholderQuestionFinalBinding

class QuestionAdapter(
    private val correctAnswer: String,
    private val users: MutableList<String> = mutableListOf(),
    private val returnScore: Score,
    private var questionActivity: QuestionMainActivity
) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    var next: Boolean = false

    interface Score {
        fun amount(number: Int, clickedAnswer: String)
    }

    private lateinit var binding: ViewholderQuestionFinalBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderQuestionFinalBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ViewholderQuestionFinalBinding.bind(holder.itemView)
        val letter = when (position) {
            0 -> "A :"
            1 -> "B :"
            2 -> "C :"
            3 -> "D :"
            4 -> "E :"
            else -> ""
        }
        binding.answerLetter.text = letter
        binding.answerTxt.text = differ.currentList[position]
        val currentPos = getAnswerPosition(correctAnswer)

        if (differ.currentList.size == 5 && currentPos == position) {
            setCorrectAnswerView(binding)
        }

        if (differ.currentList.size == 6) {
            val clickedPos = getAnswerPosition(differ.currentList[4])
            if (clickedPos == position && clickedPos != currentPos) {
                setIncorrectAnswerView(binding)
                triggerHandler()
            }
        }

        if (position == 4) {
            binding.root.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            val selectedAnswer = getAnswerLetter(position)
            users.add(4, selectedAnswer)
            notifyDataSetChanged()

            if (currentPos == position) {
                setCorrectAnswerView(binding)
                returnScore.amount(5, selectedAnswer)
            } else {
                setIncorrectAnswerView(binding)
                returnScore.amount(0, selectedAnswer)
            }
            triggerHandler()
        }
        if (differ.currentList.size == 5) holder.itemView.setOnClickListener(null)
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    private fun getAnswerPosition(answer: String): Int {
        return when (answer) {
            "a" -> 0
            "b" -> 1
            "c" -> 2
            "d" -> 3
            else -> -1
        }
    }

    private fun getAnswerLetter(position: Int): String {
        return when (position) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            3 -> "d"
            else -> ""
        }
    }

    private fun setCorrectAnswerView(binding: ViewholderQuestionFinalBinding) {
        binding.answerColor.setBackgroundResource(R.drawable.green_bg)
        val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.tick)
        binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            drawable,
            null
        )
        next = true
        //triggerHandler()
    }

    private fun setIncorrectAnswerView(binding: ViewholderQuestionFinalBinding) {
        binding.answerColor.setBackgroundResource(R.drawable.red_bg)
        val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.thieves)
        binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            drawable,
            null
        )
        next = true
        //triggerHandler()
    }

    private fun triggerHandler() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (questionActivity.binding.progressBar.progress == 10) {
                val intent = Intent(questionActivity, VictoryMainActivity::class.java)
                intent.putExtra("Score", questionActivity.allScore)
                intent.putExtra("CorrectAnswers", questionActivity.correctAnswersCount)
                intent.putExtra("PositonLevel", questionActivity.positionLevel)
                intent.putExtra("CurrentLevel", questionActivity.currentLevels)
                questionActivity.startActivity(intent)
                questionActivity.finish()
            } else {
                if (isNext()) {
                    questionActivity.position++
                    questionActivity.binding.progressBar.progress += 1
                    questionActivity.binding.questionNumberTxt.text = "Question ${questionActivity.binding.progressBar.progress}/10"
                    questionActivity.updateQuestion()
                }
            }
        }, 1500)
    }

    fun isNext(): Boolean {
        return next
    }
}