using System.Net.Http;
using System.Text;
using Newtonsoft.Json;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Collections;

public class BtnRegister : MonoBehaviour
{
    [SerializeField] private InputField inputEmail;
    [SerializeField] private InputField inputPassword;
    [SerializeField] private InputField inputName;
    [SerializeField] private InputField inputAge;
    [SerializeField] private GameObject dialogNotification;
    [SerializeField] private Text txtLoading;
    [SerializeField] private Text txtShowNotification;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void register()
    {
        string email = inputEmail.text;
        string password = inputPassword.text;
        string name = inputName.text;
        int age = System.Convert.ToInt32(inputAge.text);

        User user = new User(email, password, name, age);
        sendUserAsync(user);
    }

    async void sendUserAsync(User user)
    {
        txtLoading.text = null;
        txtShowNotification.text = null;
        dialogNotification.SetActive(true);

        StartCoroutine(runLoading());

        var content = new StringContent(JsonConvert.SerializeObject(user), Encoding.UTF8, "application/json");
        using (var httpClient = new HttpClient())
        {
            using (var response = await httpClient.PostAsync("https://rich-plum-pocket.cyclic.app/api/mob104/user/register", content))
            {
                string responseData = await response.Content.ReadAsStringAsync();
                try
                {
                    UserResponse userResponse = JsonConvert.DeserializeObject<UserResponse>(responseData);
                    if (userResponse.status == 200)
                    {
                        UserResponse.setInstance(userResponse);
                        StartCoroutine(runShowNotification("Register successfully wait for minutes...", userResponse));
                    }
                    else
                    {
                        StartCoroutine(runShowNotification("Register failed", null));
                    }
                }
                catch (System.Exception)
                {
                    StartCoroutine(runShowNotification("Register failed", null));
                }
            }
        }
    }

    private void loadScene()
    {
        SceneManager.LoadScene("Scene1");
    }
    IEnumerator runLoading()
    {
        yield return StartCoroutine(Loading());
    }
    IEnumerator runShowNotification(string s, UserResponse userResponse)
    {
        yield return StartCoroutine(ShowNotification(s));
        if (userResponse != null)
        {
            loadScene();
        }
    }
    IEnumerator Loading()
    {
        string loading = "Loading...";
        for (int i = 0; i < loading.Length; i++)
        {
            txtLoading.text += loading[i];
            yield return new WaitForSeconds(0.2f);
        }
    }

    IEnumerator ShowNotification(string s)
    {
        for (int i = 0; i < s.Length; i++)
        {
            txtShowNotification.text += s[i];
            yield return new WaitForSeconds(0.02f);
        }

        yield return new WaitForSeconds(2f);
        dialogNotification.SetActive(false);
    }
}
