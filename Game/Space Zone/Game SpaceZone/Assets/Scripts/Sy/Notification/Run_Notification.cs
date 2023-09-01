using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class Run_Notification : MonoBehaviour
{
    [SerializeField] private Text message;
    [SerializeField] private float speed;
    private float pos;

    void Start()
    {
        pos = message.rectTransform.anchoredPosition.x;
    }

    void Update()
    {
        // Di chuyển text sang phải
        pos += speed * Time.deltaTime;
        // Nếu text đã đi qua khung hình thì đặt lại vị trí ban đầu và bắt đầu lại
        if (pos > Screen.width - 100)
        {
            pos = -Screen.width + 100;
        }
        // Cập nhật vị trí mới của text
        message.rectTransform.anchoredPosition = new Vector2(-pos, message.rectTransform.anchoredPosition.y);
    }
}