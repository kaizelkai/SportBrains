package kabre.m2.sportbrains.Adaptater

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kabre.m2.sportbrains.Levels.SportLevel1
import kabre.m2.sportbrains.Manager.MusicManager
import kabre.m2.sportbrains.Model.NombreEtoile
import kabre.m2.sportbrains.QuestionMainActivity
import kabre.m2.sportbrains.R
import kabre.m2.sportbrains.databinding.ViewLevelButtomBinding

class LevelAdaptater(
    private val quizList: List<String>,
    private val context: Context,
    private var next: Int, // Indique le dernier niveau débloqué
    private val etoileList: List<NombreEtoile>, // Ajout des données d'étoiles
    private val currentLevels: Int,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<LevelAdaptater.QuizViewHolder>() {

    private val questionAllsList: SportLevel1 = SportLevel1()

    class QuizViewHolder(val binding: ViewLevelButtomBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val binding = ViewLevelButtomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.binding.level.text = quizList[position]

        // Récupération du nombre d'étoiles à partir du fichier JSON
        val nbEtoiles = etoileList.getOrNull(position)?.NbEtoile ?: 0

        // Mise à jour des étoiles en fonction du nombre d'étoiles
        when (nbEtoiles) {
            3 -> {
                holder.binding.etoile1.setImageResource(R.drawable.star_l)
                holder.binding.etoile2.setImageResource(R.drawable.star_l)
                holder.binding.etoile3.setImageResource(R.drawable.star_l)
            }
            2 -> {
                holder.binding.etoile1.setImageResource(R.drawable.star_l)
                holder.binding.etoile2.setImageResource(R.drawable.star_l)
                holder.binding.etoile3.setImageResource(R.drawable.star_on)
            }
            1 -> {
                holder.binding.etoile1.setImageResource(R.drawable.star_l)
                holder.binding.etoile2.setImageResource(R.drawable.star_on)
                holder.binding.etoile3.setImageResource(R.drawable.star_on)
            }
            else -> {
                holder.binding.etoile1.setImageResource(R.drawable.star_on)
                holder.binding.etoile2.setImageResource(R.drawable.star_on)
                holder.binding.etoile3.setImageResource(R.drawable.star_on)
            }
        }

        // Activer ou désactiver le clic en fonction du niveau débloqué
        if (position <= next) {
            holder.binding.levelNb.setOnClickListener {
                val levelQuestionList = when (position) {
                    0 -> {
                        MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot1()
                    }
                    1 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot2()
                    }
                    2 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot3()
                    }
                    3 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot4()
                    }
                    4 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot5()
                    }
                    5 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot6()
                    }
                    6 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot7()
                    }
                    7 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot8()
                    }
                    8 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot9()
                    }
                    9 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot10()
                    }
                    10 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot11()
                    }
                    11 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot12()
                    }
                    12 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot13()
                    }
                    13 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot14()
                    }
                    14 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot15()
                    }
                    15 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot16()
                    }
                    16 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot17()
                    }
                    17 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot18()
                    }
                    18 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot19()
                    }
                    19 -> {MusicManager.sonClick(context = this@LevelAdaptater.context)
                        questionAllsList.questionListFoot20()
                    }

                    else -> ArrayList()
                }

                val intent = Intent(context, QuestionMainActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(levelQuestionList))
                intent.putExtra("PositonLevel", position)
                intent.putExtra("CurrentLevel", currentLevels)
                context.startActivity(intent)

                onItemClicked(position)
            }
            if (position==next)
            {
                holder.binding.stars.visibility= View.GONE
            }else{
                holder.binding.stars.visibility= View.VISIBLE
            }

            holder.binding.levelNb.background = context.getDrawable(R.drawable.level_button_bg)
            holder.binding.level.setTextColor(context.getColor(R.color.black))
        } else {
            holder.binding.stars.visibility = View.GONE
            holder.binding.levelNb.background = context.getDrawable(R.drawable.level_on)
            holder.binding.level.setTextColor(context.getColor(R.color.black))
            holder.binding.levelNb.setOnClickListener(null)
        }
    }

    override fun getItemCount(): Int {
        return quizList.size
    }
}
